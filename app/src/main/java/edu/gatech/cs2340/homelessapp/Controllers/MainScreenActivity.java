package edu.gatech.cs2340.homelessapp.Controllers;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import edu.gatech.cs2340.homelessapp.Model.HomelessShelter;
import edu.gatech.cs2340.homelessapp.Model.Shelters;
import edu.gatech.cs2340.homelessapp.Model.Users;
import edu.gatech.cs2340.homelessapp.R;


public class MainScreenActivity extends AppCompatActivity {

    // buttons
    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
        Shelters.pullShelters();
        Button logoutButton;
        logoutButton = findViewById(R.id.logoutButton);
        logoutButton.setOnClickListener((view) -> {
            Intent newIntent = new Intent(MainScreenActivity.this, WelcomeActivity.class);
            startActivity(newIntent);
        });

        Button shelterButton;
        Button clearReservationButton;
        shelterButton = findViewById(R.id.shelterButton);
        shelterButton.setOnClickListener((view -> {
            Intent newIntent = new Intent (MainScreenActivity.this, ShelterViewActivity.class);
            Shelters.pullShelters();
            startActivity(newIntent);
        }));

        mDatabase = FirebaseDatabase.getInstance().getReference();

        clearReservationButton = findViewById(R.id.clearReservation);
        clearReservationButton.setOnClickListener(view -> {
            if ((Users.currentUser.getCurrentShelterName() != null)
                    && !"".equals(Users.currentUser.getCurrentShelterName())) {
                HomelessShelter currentShelter = Shelters.shelters.get(
                        Users.currentUser.getCurrentShelterName());
                if ((Shelters.shelters.get(
                        Users.currentUser.getCurrentShelterName()).getCapacity() != null)
                        && !"".equals(Shelters.shelters.get(
                        Users.currentUser.getCurrentShelterName()).getCapacity())) {
                    currentShelter.updateCapacity(Users.currentUser.getNumberSpotsTaken());
                }
                Users.currentUser.setNumberSpotsTaken(0);
                Users.currentUser.setCurrentShelterName("");
                Context context = getApplicationContext();
                CharSequence text = "Reservation successfully cleared!";
                Toast toast = Toast.makeText(context, text, Toast.LENGTH_SHORT);
                toast.show();
                mDatabase.child("Users").child(
                        Users.currentUser.getUsername()).setValue(Users.currentUser);
            }
        });
    }
}
