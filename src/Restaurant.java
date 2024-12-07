public class Restaurant {
    private String name;
    private String address;
    private String postcode;
    private String ratingValue;
    private String ratingData;

    public Restaurant(String name, String address, String postcode, String ratingValue, String ratingData) {
        this.name = name;
        this.address = address;
        this.postcode = postcode;
        this.ratingValue = ratingValue;
        this.ratingData = ratingData;
    }

    public Restaurant() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getRatingValue() {
        return ratingValue;
    }

    public void setRatingValue(String ratingValue) {
        this.ratingValue = ratingValue;
    }

    public String getRatingData() {
        return ratingData;
    }

    public void setRatingData(String ratingData) {
        this.ratingData = ratingData;
    }
}
