package edu.gatech.cs2340.homelessapp.Model;

import java.util.ArrayList;

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
    private String gender;
    private ArrayList<String> ageRange;
    private String currentCapacity;
    private int intOfCurrentCapacity;



    public HomelessShelter() {

    }

    public HomelessShelter(String name, String capacity, String restrictions, String longitude,
                           String latitude, String address, String phoneNumber, String specialNotes,
                           String gender, ArrayList<String> ageRange, String currentCapacity,
                           int intOfCurrentCapacity) {
        this.name = name;
        this.capacity = capacity;
        this.restrictions = restrictions;
        this.longitude = longitude;
        this.latitude = latitude;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.specialNotes = specialNotes;
        this.gender = gender;
        this.ageRange = ageRange;
        this.currentCapacity = currentCapacity;
        this.intOfCurrentCapacity = intOfCurrentCapacity;
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

    public String getGender() {
        return gender;
    }

    public ArrayList<String> getAgeRange() {
        return ageRange;
    }

    public String getCurrentCapacity() {
        return currentCapacity;
    }

    public int getIntOfCurrentCapacity() {
        return intOfCurrentCapacity;
    }

    public void setIntOfCurrentCapacity(int intOfCurrentCapacity) {
        this.intOfCurrentCapacity = intOfCurrentCapacity;
    }
}
