package edu.gatech.cs2340.homelessapp.Controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Arrays;

import edu.gatech.cs2340.homelessapp.R;

import edu.gatech.cs2340.homelessapp.Model.*;

public class RegisterActivity extends AppCompatActivity {

    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mDatabase = FirebaseDatabase.getInstance().getReference();

        Spinner typeSpinner = (Spinner) findViewById(R.id.typeSpinner);
        Button registerButton = (Button) findViewById(R.id.registerButton);
        EditText username = (EditText) findViewById(R.id.username);
        EditText password = (EditText) findViewById(R.id.password);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, Arrays.asList("User", "Admin"));
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        typeSpinner.setAdapter(adapter);

        registerButton.setOnClickListener((view -> {
            String user = username.getText().toString();
            String pass = password.getText().toString();
            typeSpinner.setSelection(0);

            if (TextUtils.isEmpty(user)) {
                username.setError(getString(R.string.error_field_required));
            } else if (TextUtils.isEmpty(pass)) {
                password.setError(getString(R.string.error_field_required));
            } else {
                HomelessUser newUser = new HomelessUser(user, pass, (String) typeSpinner.getSelectedItem());
                mDatabase.child("Users").setValue(newUser);
                Intent intent = new Intent(RegisterActivity.this, MainScreenActivity.class);
                startActivity(intent);
            }

        }));


    }
}
