package edu.gatech.cs2340.homelessapp;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import edu.gatech.cs2340.homelessapp.Controllers.FilterActivity;
import edu.gatech.cs2340.homelessapp.Model.HomelessShelter;

import static org.junit.Assert.*;

/**
 * A Unit Test for Filter Gender Tests
 * Test Created by Mukund Pandiri
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class FilterGenderTests {
    FilterActivity sampleActivity = new FilterActivity();

    String[] age = {"dhfhdfhahf"};

    //first test where we filter by male
    List shelters = new ArrayList<HomelessShelter>();
    List allShelters = new ArrayList<HomelessShelter>();
    HomelessShelter shelter1 = new HomelessShelter("shelter1", "10", "", "200",
            "100", "address", "0000000000", "",
            "Men", new ArrayList(Arrays.asList(age)), "10", 10);
    HomelessShelter shelter2 = new HomelessShelter("shelter1", "10", "", "200",
            "100", "address", "0000000000", "",
            "Women", new ArrayList(Arrays.asList(age)), "10", 10);
    HomelessShelter shelter3 = new HomelessShelter("shelter1", "10", "", "200",
            "100", "address", "0000000000", "",
            "All", new ArrayList(Arrays.asList(age)), "10", 10);
    HomelessShelter shelter4 = new HomelessShelter("shelter1", "10", "", "200",
            "100", "address", "0000000000", "",
            "", new ArrayList(Arrays.asList(age)), "10", 10);


    @Before
    public void setup () {
        allShelters.clear();
        shelters.clear();
        allShelters.add(shelter1);
        allShelters.add(shelter2);
        allShelters.add(shelter3);
        allShelters.add(shelter4);

    }


    @Test
    public void filtermale() {
        sampleActivity.filterGender(shelters, allShelters, "Men");
        assertTrue(allShelters.contains(shelter1));
        assertFalse(allShelters.contains(shelter2));
        assertFalse(allShelters.contains(shelter3));
        assertFalse(allShelters.contains(shelter4));
    }

    @Test
    public void filterfemale() {
        sampleActivity.filterGender(shelters, allShelters, "Women");
        assertTrue(allShelters.contains(shelter2));
        assertFalse(allShelters.contains(shelter1));
        assertFalse(allShelters.contains(shelter3));
        assertFalse(allShelters.contains(shelter4));
    }

    @Test
    public void filterall() {
        sampleActivity.filterGender(shelters, allShelters, "All");
        assertTrue(allShelters.contains(shelter3));
        assertFalse(allShelters.contains(shelter1));
        assertFalse(allShelters.contains(shelter2));
        assertFalse(allShelters.contains(shelter4));
    }

    @Test
    public void filternone() {
        sampleActivity.filterGender(shelters, allShelters, "");
        assertTrue(allShelters.contains(shelter2));
        assertTrue(allShelters.contains(shelter1));
        assertTrue(allShelters.contains(shelter3));
        assertTrue(allShelters.contains(shelter4));
    }

    //no need for a test for a random gender because only a legit gender is entered (because of
    //a dropdown menu
}