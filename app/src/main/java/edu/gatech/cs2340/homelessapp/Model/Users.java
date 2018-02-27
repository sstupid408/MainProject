package edu.gatech.cs2340.homelessapp.Model;

import java.util.HashMap;

/**
 * Created by Mukund on 2/19/2018.
 */

public class Users {
    public static HashMap<String, HomelessUser> users = new HashMap<>();
    public static HashMap<String, HomelessUser> getUsers() {
        return users;
    }
}
