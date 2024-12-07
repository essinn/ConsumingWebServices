import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class HygieneRatingGUI {
    private JTextField postcodeField;
    private JTextArea resultsArea;
    private HygieneServiceClient serverClient;

    public HygieneRatingGUI() {
        serverClient = new HygieneServiceClient();

        JFrame frame = new JFrame("Hygiene Rating Finder");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // input panel
        JPanel input = new JPanel();
        input.add(new JLabel("Enter postcode: "));
        postcodeField = new JTextField(10);
        input.add(postcodeField);

        JButton searchBtn = new JButton("Search");
        input.add(searchBtn);
        frame.add(input, BorderLayout.NORTH);

        // results area
        resultsArea = new JTextArea(10, 10);
        resultsArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultsArea);
        frame.add(scrollPane, BorderLayout.CENTER);

        // action listener for search btn
        searchBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String postcode = postcodeField.getText().trim();
                if (postcode.isEmpty() || postcode.length() < 3) {
                    JOptionPane.showMessageDialog(frame, "Please enter a valid postcode");
                    return;
                }

                try {
                    List<Restaurant> results = serverClient.retrieveRatings(postcode);
                    resultsArea.setText("");
                    for (Restaurant r : results) {
                        resultsArea.append(r.toString() + "\n");
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        frame.pack();
        frame.setVisible(true);
    }
}
