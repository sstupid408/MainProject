package edu.gatech.cs2340.homelessapp.Controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

import edu.gatech.cs2340.homelessapp.Model.HomelessShelter;
import edu.gatech.cs2340.homelessapp.Model.Shelters;
import edu.gatech.cs2340.homelessapp.R;

public class ShelterViewActivity extends AppCompatActivity {

    private ArrayList<String> list = new ArrayList<>();
    private Button filter;
    private Button clear;
    private Button mapView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shelter_view);
    }

    @Override
    protected void onResume() {
        super.onResume();
        list.clear();
        for (String shelterName: Shelters.shelters.keySet()) {
            list.add(shelterName);
        }
        String[] listAsArray = new String[list.size()];
        listAsArray = list.toArray(listAsArray);
        ListView lv = (ListView) findViewById(R.id.sheltersView);
        lv.setAdapter(new ArrayAdapter<String>(ShelterViewActivity.this,
                android.R.layout.simple_list_item_1, listAsArray));
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String shelterName = ((TextView)view).getText().toString();
                Shelters.selectedShelter = Shelters.shelters.get(shelterName);
                Intent intent = new Intent(ShelterViewActivity.this, ShelterInfoActivity.class);
                startActivity(intent);
            }
        });

        filter = (Button) findViewById(R.id.filterButton);
        filter.setOnClickListener(view -> {
            Intent newIntent = new Intent (ShelterViewActivity.this, FilterActivity.class);
            startActivity(newIntent);
        });

        clear = (Button) findViewById(R.id.clearButton);
        clear.setOnClickListener(view -> {
            Shelters.pullShelters();
            Intent intent = new Intent (ShelterViewActivity.this, ShelterViewActivity.class);
            startActivity(intent);
        });

        mapView = (Button) findViewById(R.id.mapViewButton);
        mapView.setOnClickListener(view -> {
            Intent newIntent = new Intent (ShelterViewActivity.this, ShelterMapsViewActivity.class);
            startActivity(newIntent);
        });
    }

    @Override
    public void onBackPressed() {
        Intent newIntent = new Intent(ShelterViewActivity.this, MainScreenActivity.class);
        startActivity(newIntent);
    }



}
