package edu.gatech.cs2340.homelessapp.Model;

/**
 * Created by Joshua on 2/27/2018.
 */

public class Shelter {
    private String name;
    private int capacity;
    private String gender;
    private double longitude;
    private double latitude;
    private String address;
    private String pnumber;



    public Shelter() {

    }

    public Shelter(String name, String capacity, String gender, String longitude, String latitude, String address, String pnumber) {
        this.name = name;
        this.capacity = Integer.parseInt(capacity);
        this.gender = gender;
        this.longitude = Double.parseDouble(longitude);
        this.latitude = Double.parseDouble(latitude);
        this.address = address;
        this.pnumber = pnumber;
    }

    public String getName() {
        return name;
    }
}
