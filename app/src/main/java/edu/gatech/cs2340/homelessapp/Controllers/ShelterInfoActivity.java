package edu.gatech.cs2340.homelessapp.Controllers;

import android.os.TestLooperManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import edu.gatech.cs2340.homelessapp.Model.Shelters;
import edu.gatech.cs2340.homelessapp.R;

public class ShelterInfoActivity extends AppCompatActivity {

    private TextView name;
    private TextView capacity;
    private TextView restrictions;
    private TextView longitude;
    private TextView latitude;
    private TextView address;
    private TextView phoneNumber;
    private TextView specialNotes;
    private TextView gender;
    private TextView ageRange;

    private String ageRangeToDisp = "";
    private String genderToDisp = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shelter_info);

        name = (TextView) findViewById(R.id.name);
        capacity = (TextView) findViewById(R.id.capacity);
        restrictions = (TextView) findViewById(R.id.restrictions);
        longitude = (TextView) findViewById(R.id.longitude);
        latitude = (TextView) findViewById(R.id.latitude);
        address = (TextView) findViewById(R.id.address);
        phoneNumber = (TextView) findViewById(R.id.phoneNumber);
        specialNotes = (TextView) findViewById(R.id.specialNotes);
        gender = (TextView) findViewById(R.id.gender);
        ageRange = (TextView) findViewById(R.id.ageRange);
        if (Shelters.selectedShelter.getAgeRange() != null) {
            for (String s : Shelters.selectedShelter.getAgeRange()) {
                ageRangeToDisp += s + " ";
            }
        } else {
            ageRangeToDisp = "All";
        }
        if (Shelters.selectedShelter.getGender() == "") {
            genderToDisp = "All";
        } else {
            genderToDisp = Shelters.selectedShelter.getGender();
        }

        name.setText(Shelters.selectedShelter.getName());
        capacity.append(Shelters.selectedShelter.getCapacity());
        restrictions.append(Shelters.selectedShelter.getRestrictions());
        longitude.append(Shelters.selectedShelter.getLongitude());
        latitude.append(Shelters.selectedShelter.getLatitude());
        address.append(Shelters.selectedShelter.getAddress());
        phoneNumber.append(Shelters.selectedShelter.getPhoneNumber());
        specialNotes.append(Shelters.selectedShelter.getSpecialNotes());
        gender.append(genderToDisp);
        ageRange.append(ageRangeToDisp);
    }


}
