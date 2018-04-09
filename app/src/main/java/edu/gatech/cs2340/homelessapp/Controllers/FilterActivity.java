package edu.gatech.cs2340.homelessapp.Controllers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import edu.gatech.cs2340.homelessapp.Model.HomelessShelter;
import edu.gatech.cs2340.homelessapp.Model.Shelters;
import edu.gatech.cs2340.homelessapp.R;

/**
 * A filter to select shelters based on certain criteria
 */
public class FilterActivity extends AppCompatActivity {

    private Spinner selectedGender;
    private Spinner selectedAge;
    private EditText selectedName;


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

        ArrayAdapter<String> forGender = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, genders);
        forGender.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        selectedGender.setAdapter(forGender);

        ArrayAdapter<String> forAgeRange = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, ages);
        forAgeRange.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        selectedAge.setAdapter(forAgeRange);

        selectedGender.setSelection(3);
        selectedAge.setSelection(4);

        accept = findViewById(R.id.acceptButton);
        accept.setOnClickListener(view -> {
            filter(new ArrayList<>(), new ArrayList<>());
            onBackPressed();
//            Intent newIntent = new Intent (FilterActivity.this, ShelterViewActivity.class);
//            startActivity(newIntent);
        });
    }

    private void filter(List<HomelessShelter> shelters, List<HomelessShelter> allShelters) {
        List<HomelessShelter> shelters1 = shelters;
        List<HomelessShelter> allShelters1 = allShelters;
        String name;
        String gender;
        String age;
        gender = (String) selectedGender.getSelectedItem();
        age = (String) selectedAge.getSelectedItem();
        Editable currentName = selectedName.getText();
        name = currentName.toString();

        for (String currentShelter : Shelters.shelters.keySet()) {
            allShelters1.add(Shelters.shelters.get(currentShelter));
        }

        allShelters1 = filterGender(shelters1, allShelters1, gender);
        shelters1 = filterAge(shelters1, allShelters1, age);

        Shelters.shelters.clear();
        for (HomelessShelter newShelter : shelters1) {
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

    /**
     * Filters shelters by gender
     *
     * @param shelters list of shelters
     * @param allShelters list of filtered shelters
     * @param gender filter criterion
     * @return list of filtered shelters
     */
    public List<HomelessShelter> filterGender(Collection<HomelessShelter> shelters,
                                              List<HomelessShelter> allShelters, String gender) {
        if (!"".equals(gender)) {
            for (HomelessShelter genderShelter : allShelters) {
                String currentGender = genderShelter.getGender();
                if(currentGender.equals(gender)) {
                    shelters.add(genderShelter);
                }
            }
            allShelters.clear();
            allShelters.addAll(shelters);
            shelters.clear();
        }
        return allShelters;
    }

    /**
     * Filters shelters by age
     *
     * @param shelters list of shelters
     * @param allShelters list of filtered shelters
     * @param age filter criterion
     * @return list of filtered shelters
     */
    public List<HomelessShelter> filterAge(List<HomelessShelter> shelters,
                                           Collection<HomelessShelter> allShelters, String age) {
        if (!"".equals(age)) {
            shelters.clear();
            for (HomelessShelter ageShelter : allShelters) {
                List<String> currentAgeRange = ageShelter.getAgeRange();
                if (currentAgeRange.contains(age)) {
                    shelters.add(ageShelter);
                }
            }
        } else {
            shelters.addAll(allShelters);
        }
        return shelters;
    }

}
