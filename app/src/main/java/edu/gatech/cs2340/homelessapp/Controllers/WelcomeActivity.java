package edu.gatech.cs2340.homelessapp.Controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import edu.gatech.cs2340.homelessapp.R;

/**
 * A screen to welcome the user to the app
 */
public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Button loginButton;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        loginButton = (findViewById(R.id.loginButton));
        loginButton.setOnClickListener((view) -> {
            Intent newIntent = new Intent(WelcomeActivity.this, LoginActivity.class);
            startActivity(newIntent);
        });

        Button registerButton = findViewById(R.id.registerButton);
        registerButton.setOnClickListener((view -> register()));

    }

    private void register() {
        Intent intent = new Intent(WelcomeActivity.this, RegisterActivity.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        Intent newIntent = new Intent(WelcomeActivity.this, WelcomeActivity.class);
        startActivity(newIntent);
    }
}
