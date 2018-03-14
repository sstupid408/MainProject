package edu.gatech.cs2340.homelessapp.Controllers;

import android.content.Context;
import android.os.TestLooperManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import edu.gatech.cs2340.homelessapp.Model.Shelters;
import edu.gatech.cs2340.homelessapp.Model.Users;
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
    private EditText numberSpots;
    private Button reserve;

    private String ageRangeToDisp = "";
    private String genderToDisp = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shelter_info);
        Shelters.pullShelters();

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
        numberSpots = (EditText) findViewById(R.id.numberSpots);
        reserve = (Button) findViewById(R.id.reserve);

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

        reserve.setOnClickListener(view -> {
            if (numberSpots.getText().toString() == null || numberSpots.getText().toString().equals("")) {
                numberSpots.setError("Cannot be empty!");
            } else {
                int selectedCapacity = Integer.parseInt(numberSpots.getText().toString());
                Context context = getApplicationContext();
                CharSequence text = "Reservation Successful!";
                Toast toast = Toast.makeText(context, text, Toast.LENGTH_SHORT);
                if (Shelters.selectedShelter.getCurrentCapacity() == null
                        || Shelters.selectedShelter.getCurrentCapacity().equals("")) {
                    Users.currentUser.setCurrentShelterName(Shelters.selectedShelter.getName());
                    Users.currentUser.setNumberSpotsTaken(selectedCapacity);
                    Shelters.selectedShelter.updateCapacity(selectedCapacity);
                    numberSpots.setText("");
                    toast.show();
                } else {
                    if (selectedCapacity > Shelters.selectedShelter.getIntOfCurrentCapacity()) {
                        numberSpots.setError("This shelter only has " + Shelters.selectedShelter.getIntOfCurrentCapacity() + " spots left!");
                    } else {
                        Users.currentUser.setCurrentShelterName(Shelters.selectedShelter.getName());
                        Users.currentUser.setNumberSpotsTaken(selectedCapacity);
                        Shelters.selectedShelter.updateCapacity(-1 * selectedCapacity);
                        numberSpots.setText("");
                        toast.show();
                    }
                }
            }
        });
    }


}
