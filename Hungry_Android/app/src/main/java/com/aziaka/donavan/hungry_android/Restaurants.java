package com.aziaka.donavan.hungry_android;

//TODO add an image to the class

public class Restaurants {

    // variable

    private String nameRestaurant;
    private String addressRestaurant;
    private boolean isChecked = true;


    public Restaurants() {

    }

    public Restaurants(String title, String address) {
        this.addressRestaurant = address;
        this.nameRestaurant = title;
    }

    public String getAddressRestaurant() {
        return addressRestaurant;
    }

    public void setAddressRestaurant(String addressRestaurant) {
        this.addressRestaurant = addressRestaurant;
    }

    public String getNameRestaurant() {
        return nameRestaurant;
    }

    public void setNameRestaurant(String nameRestaurant) {
        this.nameRestaurant = nameRestaurant;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }
}
