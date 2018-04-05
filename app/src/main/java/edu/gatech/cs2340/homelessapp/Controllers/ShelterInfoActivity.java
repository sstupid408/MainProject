package edu.gatech.cs2340.homelessapp.Controllers;

import android.content.Context;
import android.content.Intent;
import android.os.TestLooperManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import edu.gatech.cs2340.homelessapp.Model.Shelters;
import edu.gatech.cs2340.homelessapp.Model.Users;
import edu.gatech.cs2340.homelessapp.R;

public class ShelterInfoActivity extends AppCompatActivity {

    private TextView capacity;

    private EditText numberSpots;
    private DatabaseReference mDatabase;

    private String ageRangeToDisp = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shelter_info);
        Shelters.pullShelters();
        Users.pullUsers();

        TextView name;
        TextView restrictions;
        TextView longitude;
        TextView latitude;
        TextView address;
        TextView phoneNumber;
        TextView specialNotes;
        TextView gender;
        TextView ageRange;
        Button reserve;
        String genderToDisp = "";

        name = findViewById(R.id.name);
        capacity = findViewById(R.id.capacity);
        restrictions = findViewById(R.id.restrictions);
        longitude = findViewById(R.id.longitude);
        latitude = findViewById(R.id.latitude);
        address = findViewById(R.id.address);
        phoneNumber = findViewById(R.id.phoneNumber);
        specialNotes = findViewById(R.id.specialNotes);
        gender = findViewById(R.id.gender);
        ageRange = findViewById(R.id.ageRange);
        numberSpots = findViewById(R.id.numberSpots);
        reserve = findViewById(R.id.reserve);

        if (Shelters.selectedShelter.getAgeRange() != null) {
            for (String s : Shelters.selectedShelter.getAgeRange()) {
                ageRangeToDisp += s + " ";
            }
        } else {
            ageRangeToDisp = "All";
        }
        if ("".equals(Shelters.selectedShelter.getGender())) {
            genderToDisp = "All";
        } else {
            genderToDisp = Shelters.selectedShelter.getGender();
        }

        name.setText(Shelters.selectedShelter.getName());
        capacity.append(Shelters.selectedShelter.getCurrentCapacity());
        restrictions.append(Shelters.selectedShelter.getRestrictions());
        longitude.append(Shelters.selectedShelter.getLongitude());
        latitude.append(Shelters.selectedShelter.getLatitude());
        address.append(Shelters.selectedShelter.getAddress());
        phoneNumber.append(Shelters.selectedShelter.getPhoneNumber());
        specialNotes.append(Shelters.selectedShelter.getSpecialNotes());
        gender.append(genderToDisp);
        ageRange.append(ageRangeToDisp);

        mDatabase = FirebaseDatabase.getInstance().getReference();

        reserve.setOnClickListener(view -> {
            if ("".equals(numberSpots.getText().toString())) {
                numberSpots.setError("Cannot be empty!");
            } else {
                if ((Users.currentUser.getCurrentShelterName() != null)
                        && !"".equals(Users.currentUser.getCurrentShelterName())) {
                    numberSpots.setError("Clear current registration");
                } else {
                    int selectedCapacity = Integer.parseInt(numberSpots.getText().toString());
                    Context context = getApplicationContext();
                    CharSequence text = "Reservation Successful!";
                    Toast toast = Toast.makeText(context, text, Toast.LENGTH_SHORT);
                    if ((Shelters.selectedShelter.getCurrentCapacity() == null)
                            || "".equals(Shelters.selectedShelter.getCurrentCapacity())) {
                        Users.currentUser.setCurrentShelterName(Shelters.selectedShelter.getName());
                        Users.currentUser.setNumberSpotsTaken(selectedCapacity);
                        numberSpots.setText("");
                        toast.show();
                        capacity.setText("Current Capacity: "
                                + Shelters.selectedShelter.getCurrentCapacity());
                        mDatabase.child("Users").child(
                                Users.currentUser.getUsername()).setValue(Users.currentUser);
                    } else {
                        if (selectedCapacity > Shelters.selectedShelter.getIntOfCurrentCapacity()) {
                            numberSpots.setError("This shelter only has "
                                    + Shelters.selectedShelter.getIntOfCurrentCapacity()
                                    + " spots left!");
                        } else {
                            Users.currentUser.setCurrentShelterName(
                                    Shelters.selectedShelter.getName());
                            Users.currentUser.setNumberSpotsTaken(selectedCapacity);
                            Shelters.selectedShelter.updateCapacity(
                                    -1 * selectedCapacity);
                            numberSpots.setText("");
                            toast.show();
                            capacity.setText("Current Capacity: "
                                    + Shelters.selectedShelter.getCurrentCapacity());
                            mDatabase.child("Users").child(
                                    Users.currentUser.getUsername()).setValue(Users.currentUser);
                        }
                    }
                }
            }
        });
    }


}
