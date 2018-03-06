package edu.gatech.cs2340.homelessapp.Controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.HashMap;

import edu.gatech.cs2340.homelessapp.Model.Shelters;
import edu.gatech.cs2340.homelessapp.R;

public class FilterActivity extends AppCompatActivity {

    private Button accept;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter);
        Shelters.pullShelters();

        accept = (Button) findViewById(R.id.acceptButton);
        accept.setOnClickListener(view -> {
            Intent newIntent = new Intent (FilterActivity.this, ShelterViewActivity.class);
            startActivity(newIntent);
        });
    }
}
