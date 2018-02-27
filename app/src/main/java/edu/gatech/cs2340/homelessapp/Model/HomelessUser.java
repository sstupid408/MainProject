package edu.gatech.cs2340.homelessapp.Model;

/**
 * Created by Mukund on 2/19/2018.
 */

public class HomelessUser {
    private String username;
    private String password;
    private String type;

    public HomelessUser(String username, String password, String type) {
        this.username = username;
        this.password = password;
        this.type = type;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public String getType() { return type; }
}
