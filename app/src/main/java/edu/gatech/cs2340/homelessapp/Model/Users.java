package edu.gatech.cs2340.homelessapp.Model;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

/**
 * A representation of all users
 */

public class Users {

    private static final Map<String, HomelessUser> users = new HashMap<>();
    public static HomelessUser currentUser;

    /**
     * Getter method for users
     *
     * @return map of users
     */
    public static Map<String, HomelessUser> getUsers() {
        return users;
    }

    /**
     * Pulls user data from Firebase database
     */
    public static void pullUsers() {
        DatabaseReference mDatabase;
        mDatabase = FirebaseDatabase.getInstance().getReference();
        mDatabase.child("Users").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Iterable<DataSnapshot> list = dataSnapshot.getChildren();
                for (DataSnapshot user: list) {
                    HomelessUser newUser = user.getValue(HomelessUser.class);
                    if (newUser != null) {
                        users.put(newUser.getUsername(), newUser);
                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
