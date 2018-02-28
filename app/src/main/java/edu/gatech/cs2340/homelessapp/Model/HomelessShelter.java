package edu.gatech.cs2340.homelessapp.Model;

/**
 * Created by Joshua on 2/27/2018.
 */

public class HomelessShelter {
    private String name;
    private String capacity;
    private String restrictions;
    private String longitude;
    private String latitude;
    private String address;
    private String phoneNumber;
    private String specialNotes;



    public HomelessShelter() {

    }

    public HomelessShelter(String name, String capacity, String restrictions, String longitude,
                           String latitude, String address, String phoneNumber, String specialNotes) {
        this.name = name;
        this.capacity = capacity;
        this.restrictions = restrictions;
        this.longitude = longitude;
        this.latitude = latitude;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.specialNotes = specialNotes;
    }

    public String getName() {
        return name;
    }

    public String getCapacity() { return capacity; }

    public String getRestrictions() {
        return restrictions;
    }

    public String getLongitude() {
        return longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getSpecialNotes() {
        return specialNotes;
    }
}
