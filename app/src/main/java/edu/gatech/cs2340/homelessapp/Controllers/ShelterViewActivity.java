package edu.gatech.cs2340.homelessapp.Controllers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import edu.gatech.cs2340.homelessapp.Model.HomelessShelter;
import edu.gatech.cs2340.homelessapp.Model.Shelters;
import edu.gatech.cs2340.homelessapp.R;

public class ShelterViewActivity extends AppCompatActivity {

    private ArrayList<String> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shelter_view);

        Shelters.pullShelters();
        for (String shelterName: Shelters.shelters.keySet()) {
            list.add(shelterName);
        }
        String[] listAsArray = new String[list.size()];
        listAsArray = list.toArray(listAsArray);
        ListView lv = (ListView) findViewById(R.id.sheltersView);
        lv.setAdapter(new ArrayAdapter<String>(ShelterViewActivity.this,
                android.R.layout.simple_list_item_1, listAsArray));
    }
}
