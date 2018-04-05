package edu.gatech.cs2340.homelessapp.Model;

import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Amitej Venapally on 2/27/18.
 */

public class Shelters {

    public static final Map<String, HomelessShelter> shelters = new HashMap<>();
    public static HomelessShelter selectedShelter;

    public static void pullShelters() {
        DatabaseReference mDatabase;
        mDatabase = FirebaseDatabase.getInstance().getReference();
        mDatabase.child("Shelters").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Iterable<DataSnapshot> list = dataSnapshot.getChildren();
                for (DataSnapshot shelter: list) {
                    HomelessShelter newShelter = shelter.getValue(HomelessShelter.class);
                    if (newShelter != null) {
                        shelters.put(newShelter.getName(), newShelter);
                        if ((newShelter.getCurrentCapacity() != null)
                                && !"".equals(newShelter.getCurrentCapacity())) {
                            newShelter.setIntOfCurrentCapacity(
                                    Integer.parseInt(newShelter.getCurrentCapacity()));
                        }
                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
