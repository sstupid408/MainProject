package edu.gatech.cs2340.homelessapp.Model;

/**
 * A homeless user of the application
 */

public class HomelessUser {
    private String username;
    private String password;
    private String type;
    private String currentShelterName;
    private int numberSpotsTaken;

    /**
     * Empty constructor for homeless user
     */
    public HomelessUser() {

    }

    /**
     * Constructor for homeless user
     *
     * @param username user account username
     * @param password user account password
     * @param type type of user
     */
    public HomelessUser(String username, String password, String type) {
        this.username = username;
        this.password = password;
        this.type = type;
        currentShelterName = "";
        numberSpotsTaken = 0;
    }

    /**
     * Getter method for password
     *
     * @return user password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Getter method for username
     *
     * @return user username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Getter method for account type
     *
     * @return user type
     */
    public String getType() { return type; }

    /**
     * Getter method for user current shelter
     *
     * @return user current shelter name
     */
    public String getCurrentShelterName() {
        return currentShelterName;
    }

    /**
     * Setter method for user current shelter
     *
     * @param currentShelterName new shelter name
     */
    public void setCurrentShelterName(String currentShelterName) {
        this.currentShelterName = currentShelterName;
    }

    /**
     * Getter method for number of spots taken by user
     *
     * @return number of spots taken
     */
    public int getNumberSpotsTaken() {
        return numberSpotsTaken;
    }

    /**
     * Setter method for number of spots taken by user
     *
     * @param numberSpotsTaken new number of spots taken
     */
    public void setNumberSpotsTaken(int numberSpotsTaken) {
        this.numberSpotsTaken = numberSpotsTaken;
    }
}
