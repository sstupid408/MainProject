package edu.gatech.cs2340.homelessapp.Model;

import android.util.Log;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

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
    private List<String> ageRange;
    private String currentCapacity;
    private int intOfCurrentCapacity;
    private DatabaseReference mDatabase;


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
        this.ageRange = new ArrayList<>(ageRange);
        this.currentCapacity = currentCapacity;
        this.intOfCurrentCapacity = intOfCurrentCapacity;
    }

    public String getName() {
        return name;
    }

    public String getCapacity() { return capacity; }

    public CharSequence getRestrictions() {
        return restrictions;
    }

    public String getLongitude() {
        return longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public CharSequence getAddress() {
        return address;
    }

    public CharSequence getPhoneNumber() {
        return phoneNumber;
    }

    public CharSequence getSpecialNotes() {
        return specialNotes;
    }

    public String getGender() {
        return gender;
    }

    public List<String> getAgeRange() {
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

    public void updateCapacity(int intOfCurrentCapacity) {
        mDatabase = FirebaseDatabase.getInstance().getReference();
        this.intOfCurrentCapacity += intOfCurrentCapacity;
        this.currentCapacity = "" + this.intOfCurrentCapacity;
        mDatabase.child("Shelters").child(this.getName()).setValue(this);

    }
}
