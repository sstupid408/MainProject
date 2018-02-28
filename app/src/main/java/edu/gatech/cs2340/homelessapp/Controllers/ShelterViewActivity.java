package edu.gatech.cs2340.homelessapp.Controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

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
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String shelterName = ((TextView)view).getText().toString();
                Shelters.selectedShelter = Shelters.shelters.get(shelterName);
                Intent intent = new Intent(ShelterViewActivity.this, ShelterInfoActivity.class);
                startActivity(intent);
            }
        });
    }
}
