package edu.gatech.cs2340.homelessapp.Controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import edu.gatech.cs2340.homelessapp.Model.HomelessShelter;
import edu.gatech.cs2340.homelessapp.Model.Shelters;
import edu.gatech.cs2340.homelessapp.R;

public class FilterActivity extends AppCompatActivity {

    private Spinner selectedGender;
    private Spinner selectedAge;
    private EditText selectedName;
    private String gender;
    private String age;

    private List<HomelessShelter> shelters;
    private List<HomelessShelter> allShelters;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Button accept;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter);

        Shelters.pullShelters();

        selectedGender = findViewById(R.id.selectedGender);
        selectedAge = findViewById(R.id.selectedAge);
        selectedName = findViewById(R.id.selectedName);

        String[] genders = {"Men", "Women", "All", ""};
        String[] ages = {"Children", "Young adults", "Anyone", "Families", ""};

        ArrayAdapter<String> forGender = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, genders);
        forGender.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        selectedGender.setAdapter(forGender);

        ArrayAdapter<String> forAgeRange = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, ages);
        forAgeRange.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        selectedAge.setAdapter(forAgeRange);

        selectedGender.setSelection(3);
        selectedAge.setSelection(4);

        accept = findViewById(R.id.acceptButton);
        accept.setOnClickListener(view -> {
            filter();
            onBackPressed();
//            Intent newIntent = new Intent (FilterActivity.this, ShelterViewActivity.class);
//            startActivity(newIntent);
        });
    }

    private void filter() {
        String name;
        gender = (String) selectedGender.getSelectedItem();
        age = (String) selectedAge.getSelectedItem();
        name = selectedName.getText().toString();

        shelters = new ArrayList<>();
        allShelters = new ArrayList<>();
        for (String currentShelter: Shelters.shelters.keySet()) {
            allShelters.add(Shelters.shelters.get(currentShelter));
        }

        filterGender();
        filterAge();

        Shelters.shelters.clear();
        for (HomelessShelter newShelter : shelters) {
            Shelters.shelters.put(newShelter.getName(), newShelter);
        }

        if (!"".equals(name)) {
            if (Shelters.shelters.containsKey(name)) {
                HomelessShelter currentShelter = Shelters.shelters.get(name);
                Shelters.shelters.clear();
                Shelters.shelters.put(name, currentShelter);
            } else {
                Shelters.shelters.clear();
            }
        }



    }
    private void filterGender() {
        if (!"".equals(gender)) {
            for (HomelessShelter genderShelter : allShelters) {
                if(genderShelter.getGender().equals(gender)) {
                    shelters.add(genderShelter);
                }
            }
            allShelters.clear();
            allShelters.addAll(shelters);
            shelters.clear();
        }
    }
    private void filterAge() {
        if (!"".equals(age)) {
            shelters.clear();
            for (HomelessShelter ageShelter : allShelters) {
                if (ageShelter.getAgeRange().contains(age)) {
                    shelters.add(ageShelter);
                }
            }
        } else {
            shelters.addAll(allShelters);
        }
    }

}
