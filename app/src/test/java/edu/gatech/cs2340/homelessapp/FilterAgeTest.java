package edu.gatech.cs2340.homelessapp;

import android.util.Log;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import edu.gatech.cs2340.homelessapp.Controllers.FilterActivity;
import edu.gatech.cs2340.homelessapp.Model.HomelessShelter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Created by Amitej Venapally on 4/5/18.
 */

public class FilterAgeTest {

    FilterActivity filterActivity = new FilterActivity();
    String[] age1 = {"Anyone"};
    String[] age2 = {"Children"};
    String[] age3 = {"Families"};
    String[] age4 = {"Young adults"};
    String[] age5 = {""};
    String[] age6 = {"Children", "Families"};
    HomelessShelter shelter1 = new HomelessShelter("Shelter 1", "23", "none",
            "123.2331", "231.2312", "213 ensc sdss", "404-232-2342",
            "N/A", "Male", new ArrayList<>(Arrays.asList(age1)),
            "23", 23);
    HomelessShelter shelter2 = new HomelessShelter("Shelter 2", "23", "none",
            "123.2331", "231.2312", "213 ensc sdss", "404-232-2342",
            "N/A", "Male", new ArrayList<>(Arrays.asList(age2)),
            "23", 23);
    HomelessShelter shelter3 = new HomelessShelter("Shelter 3", "23", "none",
            "123.2331", "231.2312", "213 ensc sdss", "404-232-2342",
            "N/A", "Male", new ArrayList<String>(Arrays.asList(age3)),
            "23", 23);
    HomelessShelter shelter4 = new HomelessShelter("Shelter 4", "23", "none",
            "123.2331", "231.2312", "213 ensc sdss", "404-232-2342",
            "N/A", "Male", new ArrayList<String>(Arrays.asList(age4)),
            "23", 23);
    HomelessShelter shelter5 = new HomelessShelter("Shelter 5", "23", "none",
            "123.2331", "231.2312", "213 ensc sdss", "404-232-2342",
            "N/A", "Male", new ArrayList<String>(Arrays.asList(age5)),
            "23", 23);
    HomelessShelter shelter6 = new HomelessShelter("Shelter 5", "23", "none",
            "123.2331", "231.2312", "213 ensc sdss", "404-232-2342",
            "N/A", "Male", new ArrayList<String>(Arrays.asList(age6)),
            "23", 23);
    List<HomelessShelter> shelters = new ArrayList<>();
    List<HomelessShelter> allShelters = new ArrayList<>();

    @Test
    public void testIsAgeEmpty() {
        shelters.addAll(Arrays.asList(shelter1, shelter2, shelter3, shelter4, shelter5, shelter6));
        filterActivity.filterAge(shelters, allShelters, "Anyone");
        assertEquals(6, shelters.size());
    }
}
