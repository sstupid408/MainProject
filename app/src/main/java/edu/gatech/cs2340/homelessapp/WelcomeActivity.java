package edu.gatech.cs2340.homelessapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class WelcomeActivity extends AppCompatActivity {

    // buttons
    private Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        loginButton = (Button) findViewById(R.id.loginButton);
        loginButton.setOnClickListener((view) -> {
            Intent newIntent = new Intent(WelcomeActivity.this, LoginActivity.class);
            startActivity(newIntent);
        });

        Button registerButton = (Button) findViewById(R.id.registerButton);
        registerButton.setOnClickListener((view ->  {
            register();
        }));

    }

    private void register() {
        Intent intent = new Intent(WelcomeActivity.this, RegisterActivity.class);
        startActivity(intent);
    }
}
