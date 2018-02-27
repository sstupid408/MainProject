package edu.gatech.cs2340.homelessapp.Model;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

/**
 * Created by Mukund on 2/19/2018.
 */

public class Users {
    public static HashMap<String, HomelessUser> users = new HashMap<>();
    public static HashMap<String, HomelessUser> getUsers() {
        return users;
    }

    private static DatabaseReference mDatabase;

    public static void pullUsers() {
        mDatabase = FirebaseDatabase.getInstance().getReference();
        mDatabase.child("Users").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Iterable<DataSnapshot> list = dataSnapshot.getChildren();
                for (DataSnapshot user: list) {
                    HomelessUser newUser = user.getValue(HomelessUser.class);
                    users.put(newUser.getUsername(), newUser);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
