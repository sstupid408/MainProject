package edu.gatech.cs2340.homelessapp.Model;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * A homeless shelter with relevant information
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

    /**
     * Constructs an empty shelter
     */
    public HomelessShelter() {

    }

    /**
     * Construct a shelter
     *
     * @param name shelter name
     * @param capacity shelter capacity
     * @param restrictions shelter restrictions
     * @param longitude shelter longitude coordinate
     * @param latitude shelter latitude coordinate
     * @param address shelter address
     * @param phoneNumber shelter phone number
     * @param specialNotes shelter information
     * @param gender shelter gender requirement
     * @param ageRange shelter age requirement
     * @param currentCapacity current capacity of shelter
     * @param intOfCurrentCapacity shelter current capacity as an integer
     */
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

    /**
     * Getter method for shelter name
     *
     * @return shelter name
     */
    public String getName() {
        return name;
    }

    /**
     * Getter method for shelter capacity
     *
     * @return shelter capacity
     */
    public String getCapacity() { return capacity; }

    /**
     * Getter method for shelter restrictions
     *
     * @return shelter restrictions
     */
    public CharSequence getRestrictions() {
        return restrictions;
    }

    /**
     * Getter method for shelter longitude
     *
     * @return shelter longitude
     */
    public String getLongitude() {
        return longitude;
    }

    /**
     * Getter method for shelter latitude
     *
     * @return shelter latitude
     */
    public String getLatitude() {
        return latitude;
    }

    /**
     * Getter method for shelter address
     *
     * @return shelter address
     */
    public CharSequence getAddress() {
        return address;
    }

    /**
     * Getter method for shelter phone number
     *
     * @return shelter phone number
     */
    public CharSequence getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Getter method for shelter notes
     *
     * @return shelter notes
     */
    public CharSequence getSpecialNotes() {
        return specialNotes;
    }

    /**
     * Getter method for shelter gender
     *
     * @return shelter gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * Getter method for shelter age range
     *
     * @return shelter age range
     */
    public List<String> getAgeRange() {
        return ageRange;
    }

    /**
     * Getter method for shelter current capacity
     *
     * @return shelter current capacity
     */
    public String getCurrentCapacity() {
        return currentCapacity;
    }

    /**
     * Getter method for shelter current capacity as an int
     *
     * @return shelter current capacity integer
     */
    public int getIntOfCurrentCapacity() {
        return intOfCurrentCapacity;
    }

    /**
     * Setter method for shelter current capacity
     *
     * @param intOfCurrentCapacity new current capacity
     */
    public void setIntOfCurrentCapacity(int intOfCurrentCapacity) {
        this.intOfCurrentCapacity = intOfCurrentCapacity;
    }

    /**
     * Updates capacity for shelter
     *
     * @param intOfCurrentCapacity new current capacity
     */
    public void updateCapacity(int intOfCurrentCapacity) {
        FirebaseDatabase currentDatabase = FirebaseDatabase.getInstance();
        DatabaseReference mDatabase = currentDatabase.getReference();
        this.intOfCurrentCapacity += intOfCurrentCapacity;
        this.currentCapacity = "" + this.intOfCurrentCapacity;

        mDatabase.child("Shelters").child(this.getName()).setValue(this);

    }
}
