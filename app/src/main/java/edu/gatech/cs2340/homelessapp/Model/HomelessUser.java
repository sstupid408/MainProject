package edu.gatech.cs2340.homelessapp.Model;

/**
 * Created by Mukund on 2/19/2018.
 */

public class HomelessUser {
    private String username;
    private String password;
    private String type;
    private String currentShelterName;
    private int numberSpotsTaken;

    public HomelessUser() {

    }

    public HomelessUser(String username, String password, String type) {
        this.username = username;
        this.password = password;
        this.type = type;
        currentShelterName = "";
        numberSpotsTaken = 0;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public String getType() { return type; }

    public String getCurrentShelterName() {
        return currentShelterName;
    }

    public void setCurrentShelterName(String currentShelterName) {
        this.currentShelterName = currentShelterName;
    }

    public int getNumberSpotsTaken() {
        return numberSpotsTaken;
    }

    public void setNumberSpotsTaken(int numberSpotsTaken) {
        this.numberSpotsTaken = numberSpotsTaken;
    }
}
