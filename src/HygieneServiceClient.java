import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


public class HygieneServiceClient {
     public List<Restaurant> retrieveRatings(String postcode) throws Exception {
         String url = "http://sandbox.kriswelsh.com/hygieneapi/hygiene.php?op=search_postcode&postcode=" + postcode;
         URL hygieneURL = new URL(url);

         HttpURLConnection conn = (HttpURLConnection) hygieneURL.openConnection();
         conn.setRequestMethod("GET");

         // read response
         BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
         StringBuilder res = new StringBuilder();
         String line;

         while ((line = reader.readLine()) != null) {
             res.append(line);
         }
         reader.close();

         // parse JSON response
         JSONArray arr = new JSONArray(res.toString());
         List<Restaurant> restaurants = new ArrayList<>();

         for (int i = 0; i < arr.length(); i++) {
            JSONObject obj = arr.getJSONObject(i);
            Restaurant restaurant = new Restaurant();
            restaurant.setName(obj.getString("BusinessName"));
            restaurant.setAddress(obj.getString("AddressLine1"));
            restaurant.setPostcode(obj.getString("PostCode"));
            restaurant.setRatingValue(obj.getString("RatingValue"));
            restaurant.setRatingData(obj.getString("RatingDate"));
            restaurants.add(restaurant);
         }

         return restaurants;
     }
}
