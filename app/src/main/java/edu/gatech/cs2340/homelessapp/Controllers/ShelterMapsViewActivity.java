package edu.gatech.cs2340.homelessapp.Controllers;

import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import edu.gatech.cs2340.homelessapp.Model.HomelessShelter;
import edu.gatech.cs2340.homelessapp.Model.Shelters;
import edu.gatech.cs2340.homelessapp.R;

public class ShelterMapsViewActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    private Button listView;
    private Button filter;
    private Button clear;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shelter_maps_view);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        filter = (Button) findViewById(R.id.filterButton);
        filter.setOnClickListener(view -> {
            Intent newIntent = new Intent (ShelterMapsViewActivity.this, FilterActivity.class);
            startActivity(newIntent);
        });

        clear = (Button) findViewById(R.id.clearButton);
        clear.setOnClickListener(view -> {
            Shelters.pullShelters();
            Intent intent = new Intent (ShelterMapsViewActivity.this, ShelterMapsViewActivity.class);
            startActivity(intent);
        });

        listView = (Button) findViewById(R.id.listViewButton);
        listView.setOnClickListener(view -> {
            Intent newIntent = new Intent (ShelterMapsViewActivity.this, ShelterViewActivity.class);
            startActivity(newIntent);
        });
    }


    public void onResume() {
        super.onResume();
        if (mMap != null) {
            mMap.clear();


            List<HomelessShelter> shelters = new ArrayList<HomelessShelter>();
            for (String shelter : Shelters.shelters.keySet()) {
                shelters.add(Shelters.shelters.get(shelter));

            }

            for (HomelessShelter shelter : shelters) {
                mMap.addMarker(new MarkerOptions().position(getLocation(shelter.getLatitude(),shelter.getLongitude())).title(shelter.getName()));
            }
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(getLocation(shelters.get(0).getLatitude(),shelters.get(0).getLongitude()),11));

        }

    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        List<HomelessShelter> shelters = new ArrayList<HomelessShelter>();
        for (String shelter : Shelters.shelters.keySet()) {
            shelters.add(Shelters.shelters.get(shelter));

        }

        for (HomelessShelter shelter : shelters) {
            mMap.addMarker(new MarkerOptions().position(getLocation(shelter.getLatitude(),shelter.getLongitude())).title(shelter.getName()));
        }
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(getLocation(shelters.get(0).getLatitude(),shelters.get(0).getLongitude()),11));
//        LatLng sydney = new LatLng(-34, 151);
//        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }



    public LatLng getLocation(String latitude, String longitude) {
        return new LatLng(Double.parseDouble(latitude), Double.parseDouble(longitude));

    }

}

