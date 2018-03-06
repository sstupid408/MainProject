package edu.gatech.cs2340.homelessapp.Controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.HashMap;

import edu.gatech.cs2340.homelessapp.Model.Shelters;
import edu.gatech.cs2340.homelessapp.R;

public class FilterActivity extends AppCompatActivity {

    private Button accept;
    private Spinner selectedGender;
    private Spinner selectedAge;
    private EditText selectedName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter);
        Shelters.pullShelters();

        selectedGender = (Spinner) findViewById(R.id.selectedGender);
        selectedAge = (Spinner) findViewById(R.id.selectedAge);
        selectedName = (EditText) findViewById(R.id.selectedName);

        String[] genders = {"Male", "Female", "All", ""};
        String[] ages = {"Children", "Young Adults", "Anyone", "families with newborns", ""};

        ArrayAdapter<String> forGender = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, genders);
        forGender.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        selectedGender.setAdapter(forGender);

        ArrayAdapter<String> forAgeRange = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, ages);
        forAgeRange.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        selectedAge.setAdapter(forAgeRange);

        selectedGender.setSelection(3);
        selectedAge.setSelection(4);

        accept = (Button) findViewById(R.id.acceptButton);
        accept.setOnClickListener(view -> {
            Intent newIntent = new Intent (FilterActivity.this, ShelterViewActivity.class);
            startActivity(newIntent);
        });
    }
}
