package edu.gatech.cs2340.homelessapp.Controllers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import edu.gatech.cs2340.homelessapp.Model.Shelters;
import edu.gatech.cs2340.homelessapp.R;

public class ShelterInfoActivity extends AppCompatActivity {

    private TextView name;
    private TextView capacity;
    private TextView gender;
    private TextView longitude;
    private TextView latitude;
    private TextView address;
    private TextView phoneNumber;
    private TextView specialNotes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shelter_info);

        name = (TextView) findViewById(R.id.name);
        capacity = (TextView) findViewById(R.id.capacity);
        gender = (TextView) findViewById(R.id.gender);
        longitude = (TextView) findViewById(R.id.longitude);
        latitude = (TextView) findViewById(R.id.latitude);
        address = (TextView) findViewById(R.id.address);
        phoneNumber = (TextView) findViewById(R.id.phoneNumber);
        specialNotes = (TextView) findViewById(R.id.specialNotes);

        name.setText(Shelters.selectedShelter.getName());
        capacity.append(Shelters.selectedShelter.getCapacity());
        gender.append(Shelters.selectedShelter.getRestrictions());
        longitude.append(Shelters.selectedShelter.getLongitude());
        latitude.append(Shelters.selectedShelter.getLatitude());
        address.append(Shelters.selectedShelter.getAddress());
        phoneNumber.append(Shelters.selectedShelter.getPhoneNumber());
        specialNotes.append(Shelters.selectedShelter.getSpecialNotes());
    }


}
