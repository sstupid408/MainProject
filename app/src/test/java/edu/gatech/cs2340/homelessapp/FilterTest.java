package edu.gatech.cs2340.homelessapp;

import edu.gatech.cs2340.homelessapp.Controllers.FilterActivity;
import edu.gatech.cs2340.homelessapp.Model.HomelessShelter;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import edu.gatech.cs2340.homelessapp.Model.Shelters;
import static org.junit.Assert.assertEquals;

/**
 * Created by Joshua Kim on 4/8/18.
 */

public class FilterTest {

    private FilterActivity filterActivity = new FilterActivity();
    private String gender1 = "Men";
    private String gender2 = "Women";
    private String gender3 = "All";
    private String[] age1 = {"Anyone"};
    private String[] age2 = {"Children"};
    private String[] age3 = {"Families"};
    private String[] age4 = {"Young adults"};
    private String[] age5 = {""};
    private String[] age6 = {"Children", "Families"};
    private HomelessShelter shelter1 = new HomelessShelter("Shelter 1", "50", "none",
            "123.2331", "231.2312", "213 ensc sdss", "404-555-0123",
            "N/A", gender1, new ArrayList<>(Arrays.asList(age5)),
            "23", 23);
    private HomelessShelter shelter2 = new HomelessShelter("Shelter 2", "50", "none",
            "123.2331", "231.2312", "213 ensc sdss", "404-555-0123",
            "N/A", gender2, new ArrayList<>(Arrays.asList(age1)),
            "23", 23);
    private HomelessShelter shelter3 = new HomelessShelter("Shelter 3", "50", "none",
            "123.2331", "231.2312", "213 ensc sdss", "404-555-0123",
            "N/A", gender3, new ArrayList<>(Arrays.asList(age6)),
            "23", 23);
    private HomelessShelter shelter4 = new HomelessShelter("Shelter 4", "50", "none",
            "123.2331", "231.2312", "213 ensc sdss", "404-555-0123",
            "N/A", gender3, new ArrayList<>(Arrays.asList(age3)),
            "23", 23);
    private HomelessShelter shelter5 = new HomelessShelter("Shelter 5", "50", "none",
            "123.2331", "231.2312", "213 ensc sdss", "404-555-0123",
            "N/A", gender2, new ArrayList<>(Arrays.asList(age4)),
            "23", 23);
    private HomelessShelter shelter6 = new HomelessShelter("Shelter 6", "50", "none",
            "123.2331", "231.2312", "213 ensc sdss", "404-555-0123",
            "N/A", gender2, new ArrayList<>(Arrays.asList(age1)),
            "23", 23);
    private HomelessShelter shelter7 = new HomelessShelter("Shelter 7", "50", "none",
            "123.2331", "231.2312", "213 ensc sdss", "404-555-0123",
            "N/A", gender3, new ArrayList<>(Arrays.asList(age2)),
            "23", 23);
    private HomelessShelter shelter8 = new HomelessShelter("Shelter 8", "50", "none",
            "123.2331", "231.2312", "213 ensc sdss", "404-555-0123",
            "N/A", gender3, new ArrayList<>(Arrays.asList(age1)),
            "23", 23);

    @Test
    public void testWhenGenderIsNotEmpty1() {
        List<HomelessShelter> shelters = new ArrayList<>();
        List<HomelessShelter> allShelters = new ArrayList<>();
        allShelters.addAll(Arrays.asList(shelter1, shelter2, shelter3, shelter4, shelter5, shelter6, shelter7, shelter8));
        shelters.clear();
        filterActivity.filter(shelters, allShelters, "", gender1, "");
        assertEquals(1, shelters.size());
        assertEquals("Shelter 1", shelters.get(0).getName());
    }

    @Test
    public void testWhenGenderIsNotEmpty2() {
        List<HomelessShelter> shelters = new ArrayList<>();
        List<HomelessShelter> allShelters = new ArrayList<>();
        allShelters.addAll(Arrays.asList(shelter1, shelter2, shelter3, shelter4, shelter5, shelter6, shelter7, shelter8));
        shelters.clear();
        filterActivity.filter(shelters, allShelters, "", gender2, "");
        assertEquals(3, shelters.size());
        assertEquals("Shelter 2", shelters.get(0).getName());
        assertEquals("Shelter 5", shelters.get(1).getName());
        assertEquals("Shelter 6", shelters.get(2).getName());
    }

    @Test
    public void testWhenGenderIsNotEmpty3() {
        List<HomelessShelter> shelters = new ArrayList<>();
        List<HomelessShelter> allShelters = new ArrayList<>();
        allShelters.addAll(Arrays.asList(shelter1, shelter2, shelter3, shelter4, shelter5, shelter6, shelter7, shelter8));
        shelters.clear();
        filterActivity.filter(shelters, allShelters, "", gender3, "");
        assertEquals(4, shelters.size());
        assertEquals("Shelter 3", shelters.get(0).getName());
        assertEquals("Shelter 4", shelters.get(1).getName());
        assertEquals("Shelter 7", shelters.get(2).getName());
        assertEquals("Shelter 8", shelters.get(3).getName());
    }

    @Test
    public void testWhenAgeIsNotEmpty1() {
        List<HomelessShelter> shelters = new ArrayList<>();
        List<HomelessShelter> allShelters = new ArrayList<>();
        allShelters.addAll(Arrays.asList(shelter1, shelter2, shelter3, shelter4, shelter5, shelter6, shelter7, shelter8));
        shelters.clear();
        filterActivity.filter(shelters, allShelters, "", "", "Anyone");
        assertEquals(3, shelters.size());
        assertEquals("Shelter 2", shelters.get(0).getName());
        assertEquals("Shelter 6", shelters.get(1).getName());
        assertEquals("Shelter 8", shelters.get(2).getName());
    }

    @Test
    public void testWhenAgeIsNotEmpty2() {
        List<HomelessShelter> shelters = new ArrayList<>();
        List<HomelessShelter> allShelters = new ArrayList<>();
        allShelters.addAll(Arrays.asList(shelter1, shelter2, shelter3, shelter4, shelter5, shelter6, shelter7, shelter8));
        shelters.clear();
        filterActivity.filter(shelters, allShelters, "", "", "Families");
        assertEquals(2, shelters.size());
        assertEquals("Shelter 3", shelters.get(0).getName());
        assertEquals("Shelter 4", shelters.get(1).getName());
    }

    @Test
    public void testWhenAgeIsNotEmpty3() {
        List<HomelessShelter> shelters = new ArrayList<>();
        List<HomelessShelter> allShelters = new ArrayList<>();
        allShelters.addAll(Arrays.asList(shelter1, shelter2, shelter3, shelter4, shelter5, shelter6, shelter7, shelter8));
        shelters.clear();
        filterActivity.filter(shelters, allShelters, "", "", "Young adults");
        assertEquals(1, shelters.size());
        assertEquals("Shelter 5", shelters.get(0).getName());
    }

    @Test
    public void testWhenAgeIsNotEmpty4() {
        List<HomelessShelter> shelters = new ArrayList<>();
        List<HomelessShelter> allShelters = new ArrayList<>();
        allShelters.addAll(Arrays.asList(shelter1, shelter2, shelter3, shelter4, shelter5, shelter6, shelter7, shelter8));
        shelters.clear();
        filterActivity.filter(shelters, allShelters, "", "", "Children");
        assertEquals(2, shelters.size());
        assertEquals("Shelter 3", shelters.get(0).getName());
        assertEquals("Shelter 7", shelters.get(1).getName());
        shelters.clear();
    }

    @Test
    public void testWhenGenderAndAgeIsNotEmpty1() {
        List<HomelessShelter> shelters = new ArrayList<>();
        List<HomelessShelter> allShelters = new ArrayList<>();
        allShelters.addAll(Arrays.asList(shelter1, shelter2, shelter3, shelter4, shelter5, shelter6, shelter7, shelter8));
        shelters.clear();
        filterActivity.filter(shelters, allShelters, "", "Men", "Anyone");
        assertEquals(0, shelters.size());
    }

    @Test
    public void testWhenGenderAndAgeIsNotEmpty2() {
        List<HomelessShelter> shelters = new ArrayList<>();
        List<HomelessShelter> allShelters = new ArrayList<>();
        allShelters.addAll(Arrays.asList(shelter1, shelter2, shelter3, shelter4, shelter5, shelter6, shelter7, shelter8));
        shelters.clear();
        filterActivity.filter(shelters, allShelters, "", "Men", "Children");
        assertEquals(0, shelters.size());
    }

    @Test
    public void testWhenGenderAndAgeIsNotEmpty3() {
        List<HomelessShelter> shelters = new ArrayList<>();
        List<HomelessShelter> allShelters = new ArrayList<>();
        allShelters.addAll(Arrays.asList(shelter1, shelter2, shelter3, shelter4, shelter5, shelter6, shelter7, shelter8));
        shelters.clear();
        filterActivity.filter(shelters, allShelters, "", "Men", "Families");
        assertEquals(0, shelters.size());
    }

    @Test
    public void testWhenGenderAndAgeIsNotEmpty4() {
        List<HomelessShelter> shelters = new ArrayList<>();
        List<HomelessShelter> allShelters = new ArrayList<>();
        allShelters.addAll(Arrays.asList(shelter1, shelter2, shelter3, shelter4, shelter5, shelter6, shelter7, shelter8));
        shelters.clear();
        filterActivity.filter(shelters, allShelters, "", "Men", "Young adults");
        assertEquals(0, shelters.size());
    }

    @Test
    public void testWhenGenderAndAgeIsNotEmpty5() {
        List<HomelessShelter> shelters = new ArrayList<>();
        List<HomelessShelter> allShelters = new ArrayList<>();
        allShelters.addAll(Arrays.asList(shelter1, shelter2, shelter3, shelter4, shelter5, shelter6, shelter7, shelter8));
        shelters.clear();
        filterActivity.filter(shelters, allShelters, "", "Women", "Anyone");
        assertEquals(2, shelters.size());
        assertEquals("Shelter 2", shelters.get(0).getName());
        assertEquals("Shelter 6", shelters.get(1).getName());
    }

    @Test
    public void testWhenGenderAndAgeIsNotEmpty6() {
        List<HomelessShelter> shelters = new ArrayList<>();
        List<HomelessShelter> allShelters = new ArrayList<>();
        allShelters.addAll(Arrays.asList(shelter1, shelter2, shelter3, shelter4, shelter5, shelter6, shelter7, shelter8));
        shelters.clear();
        filterActivity.filter(shelters, allShelters, "", "Women", "Children");
        assertEquals(0, shelters.size());
    }

    @Test
    public void testWhenGenderAndAgeIsNotEmpty7() {
        List<HomelessShelter> shelters = new ArrayList<>();
        List<HomelessShelter> allShelters = new ArrayList<>();
        allShelters.addAll(Arrays.asList(shelter1, shelter2, shelter3, shelter4, shelter5, shelter6, shelter7, shelter8));
        shelters.clear();
        filterActivity.filter(shelters, allShelters, "", "Women", "Families");
        assertEquals(0, shelters.size());
    }

    @Test
    public void testWhenGenderAndAgeIsNotEmpty8() {
        List<HomelessShelter> shelters = new ArrayList<>();
        List<HomelessShelter> allShelters = new ArrayList<>();
        allShelters.addAll(Arrays.asList(shelter1, shelter2, shelter3, shelter4, shelter5, shelter6, shelter7, shelter8));
        shelters.clear();
        filterActivity.filter(shelters, allShelters, "", "Women", "Young adults");
        assertEquals(1, shelters.size());
        assertEquals("Shelter 5", shelters.get(0).getName());
    }

    @Test
    public void testWhenGenderAndAgeIsNotEmpty9() {
        List<HomelessShelter> shelters = new ArrayList<>();
        List<HomelessShelter> allShelters = new ArrayList<>();
        allShelters.addAll(Arrays.asList(shelter1, shelter2, shelter3, shelter4, shelter5, shelter6, shelter7, shelter8));
        shelters.clear();
        filterActivity.filter(shelters, allShelters, "", "All", "Anyone");
        assertEquals(1, shelters.size());
        assertEquals("Shelter 8", shelters.get(0).getName());
    }


    @Test
    public void testWhenGenderAndAgeIsNotEmpty10() {
        List<HomelessShelter> shelters = new ArrayList<>();
        List<HomelessShelter> allShelters = new ArrayList<>();
        allShelters.addAll(Arrays.asList(shelter1, shelter2, shelter3, shelter4, shelter5, shelter6, shelter7, shelter8));
        shelters.clear();
        filterActivity.filter(shelters, allShelters, "", "All", "Young adults");
        assertEquals(0, shelters.size());
    }

    @Test
    public void testWhenNameIsNotEmpty1() {
        List<HomelessShelter> shelters = new ArrayList<>();
        List<HomelessShelter> allShelters = new ArrayList<>();
        allShelters.addAll(Arrays.asList(shelter1, shelter2, shelter3, shelter4, shelter5, shelter6, shelter7, shelter8));
        shelters.clear();
        filterActivity.filter(shelters, allShelters, "Shelter 1", "", "");
        assertEquals(1, Shelters.shelters.size());
        assertEquals(shelter1, Shelters.shelters.get("Shelter 1"));
    }

    @Test
    public void testWhenNameIsNotEmpty2() {
        List<HomelessShelter> shelters = new ArrayList<>();
        List<HomelessShelter> allShelters = new ArrayList<>();
        allShelters.addAll(Arrays.asList(shelter1, shelter2, shelter3, shelter4, shelter5, shelter6, shelter7, shelter8));
        shelters.clear();
        filterActivity.filter(shelters, allShelters, "Shelter 1", "Women", "");
        assertEquals(0, Shelters.shelters.size());
    }

    @Test
    public void testWhenNameIsNotEmpty3() {
        List<HomelessShelter> shelters = new ArrayList<>();
        List<HomelessShelter> allShelters = new ArrayList<>();
        allShelters.addAll(Arrays.asList(shelter1, shelter2, shelter3, shelter4, shelter5, shelter6, shelter7, shelter8));
        shelters.clear();
        filterActivity.filter(shelters, allShelters, "Shelter 2", "Women", "Anyone");
        assertEquals(1, Shelters.shelters.size());
        assertEquals(shelter2, Shelters.shelters.get("Shelter 2"));
    }

    @Test
    public void testWhenNameIsNotEmpty4() {
        List<HomelessShelter> shelters = new ArrayList<>();
        List<HomelessShelter> allShelters = new ArrayList<>();
        allShelters.addAll(Arrays.asList(shelter1, shelter2, shelter3, shelter4, shelter5, shelter6, shelter7, shelter8));
        shelters.clear();
        filterActivity.filter(shelters, allShelters, "Shelter 2", "Women", "Young Adults");
        assertEquals(0, Shelters.shelters.size());
    }

    @Test
    public void testWhenNameIsNotEmpty5() {
        List<HomelessShelter> shelters = new ArrayList<>();
        List<HomelessShelter> allShelters = new ArrayList<>();
        allShelters.addAll(Arrays.asList(shelter1, shelter2, shelter3, shelter4, shelter5, shelter6, shelter7, shelter8));
        shelters.clear();
        filterActivity.filter(shelters, allShelters, "Shelter 3", "", "");
        assertEquals(1, Shelters.shelters.size());
        assertEquals(shelter3, Shelters.shelters.get("Shelter 3"));
    }

    @Test
    public void testWhenNameIsNotEmpty6() {
        List<HomelessShelter> shelters = new ArrayList<>();
        List<HomelessShelter> allShelters = new ArrayList<>();
        allShelters.addAll(Arrays.asList(shelter1, shelter2, shelter3, shelter4, shelter5, shelter6, shelter7, shelter8));
        shelters.clear();
        filterActivity.filter(shelters, allShelters, "Shelter 3", "Men", "Families");
        assertEquals(0, Shelters.shelters.size());
    }

    @Test
    public void testWhenNameIsNotEmpty7() {
        List<HomelessShelter> shelters = new ArrayList<>();
        List<HomelessShelter> allShelters = new ArrayList<>();
        allShelters.addAll(Arrays.asList(shelter1, shelter2, shelter3, shelter4, shelter5, shelter6, shelter7, shelter8));
        shelters.clear();
        filterActivity.filter(shelters, allShelters, "Shelter 3", "Men", "Families");
        assertEquals(0, Shelters.shelters.size());
    }

    @Test
    public void testWhenNameIsNotEmpty8() {
        List<HomelessShelter> shelters = new ArrayList<>();
        List<HomelessShelter> allShelters = new ArrayList<>();
        allShelters.addAll(Arrays.asList(shelter1, shelter2, shelter3, shelter4, shelter5, shelter6, shelter7, shelter8));
        shelters.clear();
        filterActivity.filter(shelters, allShelters, "Shelter 4", "All", "Families");
        assertEquals(1, Shelters.shelters.size());
        assertEquals(shelter4, Shelters.shelters.get("Shelter 4"));
    }

    @Test
    public void testWhenNameIsNotEmpty9() {
        List<HomelessShelter> shelters = new ArrayList<>();
        List<HomelessShelter> allShelters = new ArrayList<>();
        allShelters.addAll(Arrays.asList(shelter1, shelter2, shelter3, shelter4, shelter5, shelter6, shelter7, shelter8));
        shelters.clear();
        filterActivity.filter(shelters, allShelters, "Shelter 4", "", "Anyone");
        assertEquals(0, Shelters.shelters.size());
    }

    @Test
    public void testWhenNameIsNotEmpty10() {
        List<HomelessShelter> shelters = new ArrayList<>();
        List<HomelessShelter> allShelters = new ArrayList<>();
        allShelters.addAll(Arrays.asList(shelter1, shelter2, shelter3, shelter4, shelter5, shelter6, shelter7, shelter8));
        shelters.clear();
        filterActivity.filter(shelters, allShelters, "Shelter 5", "", "");
        assertEquals(1, Shelters.shelters.size());
        assertEquals(shelter5, Shelters.shelters.get("Shelter 5"));
    }

    @Test
    public void testWhenNameIsNotEmpty11() {
        List<HomelessShelter> shelters = new ArrayList<>();
        List<HomelessShelter> allShelters = new ArrayList<>();
        allShelters.addAll(Arrays.asList(shelter1, shelter2, shelter3, shelter4, shelter5, shelter6, shelter7, shelter8));
        shelters.clear();
        filterActivity.filter(shelters, allShelters, "Shelter 6", "", "");
        assertEquals(1, Shelters.shelters.size());
        assertEquals(shelter6, Shelters.shelters.get("Shelter 6"));
    }

    @Test
    public void testWhenNameIsNotEmpty12() {
        List<HomelessShelter> shelters = new ArrayList<>();
        List<HomelessShelter> allShelters = new ArrayList<>();
        allShelters.addAll(Arrays.asList(shelter1, shelter2, shelter3, shelter4, shelter5, shelter6, shelter7, shelter8));
        shelters.clear();
        filterActivity.filter(shelters, allShelters, "Shelter 7", "", "");
        assertEquals(1, Shelters.shelters.size());
        assertEquals(shelter7, Shelters.shelters.get("Shelter 7"));
    }

    @Test
    public void testWhenNameIsNotEmpty13() {
        List<HomelessShelter> shelters = new ArrayList<>();
        List<HomelessShelter> allShelters = new ArrayList<>();
        allShelters.addAll(Arrays.asList(shelter1, shelter2, shelter3, shelter4, shelter5, shelter6, shelter7, shelter8));
        shelters.clear();
        filterActivity.filter(shelters, allShelters, "Shelter 8", "", "");
        assertEquals(1, Shelters.shelters.size());
        assertEquals(shelter8, Shelters.shelters.get("Shelter 8"));
    }

    @Test
    public void testWhenNameIsNotEmpty14() {
        List<HomelessShelter> shelters = new ArrayList<>();
        List<HomelessShelter> allShelters = new ArrayList<>();
        allShelters.addAll(Arrays.asList(shelter1, shelter2, shelter3, shelter4, shelter5, shelter6, shelter7, shelter8));
        shelters.clear();
        filterActivity.filter(shelters, allShelters, "Shelter 8", "All", "Families");
        assertEquals(0, Shelters.shelters.size());
    }

    @Test
    public void testWhenNameIsNotEmpty15() {
        List<HomelessShelter> shelters = new ArrayList<>();
        List<HomelessShelter> allShelters = new ArrayList<>();
        allShelters.addAll(Arrays.asList(shelter1, shelter2, shelter3, shelter4, shelter5, shelter6, shelter7, shelter8));
        shelters.clear();
        filterActivity.filter(shelters, allShelters, "Shelter 8", "", "Families");
        assertEquals(0, Shelters.shelters.size());
    }

    @Test
    public void testWhenNameIsNotEmpty16() {
        List<HomelessShelter> shelters = new ArrayList<>();
        List<HomelessShelter> allShelters = new ArrayList<>();
        allShelters.addAll(Arrays.asList(shelter1, shelter2, shelter3, shelter4, shelter5, shelter6, shelter7, shelter8));
        shelters.clear();
        filterActivity.filter(shelters, allShelters, "Shelter 8", "Men", "Families");
        assertEquals(0, Shelters.shelters.size());
    }

    @Test
    public void testWhenNameIsNotEmpty17() {
        List<HomelessShelter> shelters = new ArrayList<>();
        List<HomelessShelter> allShelters = new ArrayList<>();
        allShelters.addAll(Arrays.asList(shelter1, shelter2, shelter3, shelter4, shelter5, shelter6, shelter7, shelter8));
        shelters.clear();
        filterActivity.filter(shelters, allShelters, "Shelter 8", "Men", "");
        assertEquals(0, Shelters.shelters.size());
    }

    @Test
    public void testWhenNameIsNotEmpty18() {
        List<HomelessShelter> shelters = new ArrayList<>();
        List<HomelessShelter> allShelters = new ArrayList<>();
        allShelters.addAll(Arrays.asList(shelter1, shelter2, shelter3, shelter4, shelter5, shelter6, shelter7, shelter8));
        shelters.clear();
        filterActivity.filter(shelters, allShelters, "Shelter 8", "Women", "");
        assertEquals(0, Shelters.shelters.size());
    }

    @Test
    public void testWhenNameIsNotEmpty19() {
        List<HomelessShelter> shelters = new ArrayList<>();
        List<HomelessShelter> allShelters = new ArrayList<>();
        allShelters.addAll(Arrays.asList(shelter1, shelter2, shelter3, shelter4, shelter5, shelter6, shelter7, shelter8));
        shelters.clear();
        filterActivity.filter(shelters, allShelters, "Shelter 8", "Women", "Young adults");
        assertEquals(0, Shelters.shelters.size());
    }

    @Test
    public void testWhenNameIsNotEmpty20() {
        List<HomelessShelter> shelters = new ArrayList<>();
        List<HomelessShelter> allShelters = new ArrayList<>();
        allShelters.addAll(Arrays.asList(shelter1, shelter2, shelter3, shelter4, shelter5, shelter6, shelter7, shelter8));
        shelters.clear();
        filterActivity.filter(shelters, allShelters, "Shelter 8", "", "Young adults");
        assertEquals(0, Shelters.shelters.size());
    }

    @Test
    public void testWhenNameIsNotEmpty21() {
        List<HomelessShelter> shelters = new ArrayList<>();
        List<HomelessShelter> allShelters = new ArrayList<>();
        allShelters.addAll(Arrays.asList(shelter1, shelter2, shelter3, shelter4, shelter5, shelter6, shelter7, shelter8));
        shelters.clear();
        filterActivity.filter(shelters, allShelters, "Shelter 8", "Women", "Children");
        assertEquals(0, Shelters.shelters.size());
    }

    @Test
    public void testWhenNameIsNotEmpty22() {
        List<HomelessShelter> shelters = new ArrayList<>();
        List<HomelessShelter> allShelters = new ArrayList<>();
        allShelters.addAll(Arrays.asList(shelter1, shelter2, shelter3, shelter4, shelter5, shelter6, shelter7, shelter8));
        shelters.clear();
        filterActivity.filter(shelters, allShelters, "Shelter 8", "Men", "Young adults");
        assertEquals(0, Shelters.shelters.size());
    }

    @Test
    public void testWhenNameIsNotEmpty23() {
        List<HomelessShelter> shelters = new ArrayList<>();
        List<HomelessShelter> allShelters = new ArrayList<>();
        allShelters.addAll(Arrays.asList(shelter1, shelter2, shelter3, shelter4, shelter5, shelter6, shelter7, shelter8));
        shelters.clear();
        filterActivity.filter(shelters, allShelters, "Shelter 6", "Women", "Anyone");
        assertEquals(1, Shelters.shelters.size());
        assertEquals(shelter6, Shelters.shelters.get("Shelter 6"));
    }
}