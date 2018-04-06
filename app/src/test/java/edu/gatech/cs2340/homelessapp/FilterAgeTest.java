package edu.gatech.cs2340.homelessapp;

import android.util.Log;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import edu.gatech.cs2340.homelessapp.Controllers.FilterActivity;
import edu.gatech.cs2340.homelessapp.Model.HomelessShelter;

import static org.junit.Assert.assertEquals;

/**
 * Created by Amitej Venapally on 4/5/18.
 */

public class FilterAgeTest {

    private FilterActivity filterActivity = new FilterActivity();
    private String[] age1 = {"Anyone"};
    private String[] age2 = {"Children"};
    private String[] age3 = {"Families"};
    private String[] age4 = {"Young adults"};
    private String[] age5 = {""};
    private String[] age6 = {"Children", "Families"};
    private HomelessShelter shelter1 = new HomelessShelter("Shelter 1", "23", "none",
            "123.2331", "231.2312", "213 ensc sdss", "404-232-2342",
            "N/A", "Male", new ArrayList<>(Arrays.asList(age1)),
            "23", 23);
    private HomelessShelter shelter2 = new HomelessShelter("Shelter 2", "23", "none",
            "123.2331", "231.2312", "213 ensc sdss", "404-232-2342",
            "N/A", "Male", new ArrayList<>(Arrays.asList(age2)),
            "23", 23);
    private HomelessShelter shelter3 = new HomelessShelter("Shelter 3", "23", "none",
            "123.2331", "231.2312", "213 ensc sdss", "404-232-2342",
            "N/A", "Male", new ArrayList<String>(Arrays.asList(age3)),
            "23", 23);
    private HomelessShelter shelter4 = new HomelessShelter("Shelter 4", "23", "none",
            "123.2331", "231.2312", "213 ensc sdss", "404-232-2342",
            "N/A", "Male", new ArrayList<String>(Arrays.asList(age4)),
            "23", 23);
    private HomelessShelter shelter5 = new HomelessShelter("Shelter 5", "23", "none",
            "123.2331", "231.2312", "213 ensc sdss", "404-232-2342",
            "N/A", "Male", new ArrayList<String>(Arrays.asList(age5)),
            "23", 23);
    private HomelessShelter shelter6 = new HomelessShelter("Shelter 6", "23", "none",
            "123.2331", "231.2312", "213 ensc sdss", "404-232-2342",
            "N/A", "Male", new ArrayList<String>(Arrays.asList(age6)),
            "23", 23);
    private List<HomelessShelter> shelters = new ArrayList<>();
    private List<HomelessShelter> allShelters = new ArrayList<>();

    @Before
    public void setUp() {
        allShelters.addAll(Arrays.asList(shelter1, shelter2, shelter3, shelter4, shelter5, shelter6));
    }

    @Test
    public void testWhenAgeIsEmpty() {
        shelters = filterActivity.filterAge(shelters, allShelters, "");
        assertEquals(6, shelters.size());
        assertEquals("Shelter 1", shelters.get(0).getName());
        assertEquals("Shelter 2", shelters.get(1).getName());
        assertEquals("Shelter 3", shelters.get(2).getName());
        assertEquals("Shelter 4", shelters.get(3).getName());
        assertEquals("Shelter 5", shelters.get(4).getName());
        assertEquals("Shelter 6", shelters.get(5).getName());
    }

    @Test
    public void testWhenAgeIsAnyone() {
        shelters = filterActivity.filterAge(shelters, allShelters, "Anyone");
        assertEquals(1, shelters.size());
        assertEquals("Shelter 1", shelters.get(0).getName());
    }

    @Test
    public void testWhenAgeIsChildren() {
        shelters = filterActivity.filterAge(shelters, allShelters, "Children");
        assertEquals(2, shelters.size());
        assertEquals("Shelter 2", shelters.get(0).getName());
        assertEquals("Shelter 6", shelters.get(1).getName());
    }

    @Test
    public void testWhenAgeIsFamilies() {
        shelters = filterActivity.filterAge(shelters, allShelters, "Families");
        assertEquals(2, shelters.size());
        assertEquals("Shelter 3", shelters.get(0).getName());
        assertEquals("Shelter 6", shelters.get(1).getName());
    }

    @Test
    public void testWhenAgeIsYoungAdults() {
        shelters = filterActivity.filterAge(shelters, allShelters, "Young adults");
        assertEquals(1, shelters.size());
        assertEquals("Shelter 4", shelters.get(0).getName());
    }
}
