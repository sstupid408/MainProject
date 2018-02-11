package edu.gatech.cs2340.homelessapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class MainScreenActivity extends AppCompatActivity {

    // buttons
    private Button logoutButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);

        logoutButton = (Button) findViewById(R.id.logoutButton);
        logoutButton.setOnClickListener((view) -> {
            Intent newIntent = new Intent(MainScreenActivity.this, WelcomeActivity.class);
            startActivity(newIntent);
        });
    }
}
