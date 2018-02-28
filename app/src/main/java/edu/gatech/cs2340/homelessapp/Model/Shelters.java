package edu.gatech.cs2340.homelessapp.Model;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

/**
 * Created by Amitej Venapally on 2/27/18.
 */

public class Shelters {
    private static DatabaseReference mDatabase;

    public static HashMap<String, HomelessShelter> shelters = new HashMap<>();
    public static HomelessShelter selectedShelter;

    public static void pullShelters() {
        mDatabase = FirebaseDatabase.getInstance().getReference();
        mDatabase.child("Shelters").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Iterable<DataSnapshot> list = dataSnapshot.getChildren();
                for (DataSnapshot shelter: list) {
                    HomelessShelter newShelter = shelter.getValue(HomelessShelter.class);
                    shelters.put(newShelter.getName(), newShelter);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
