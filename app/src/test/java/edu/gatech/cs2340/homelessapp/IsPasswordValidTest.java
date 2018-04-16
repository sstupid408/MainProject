package edu.gatech.cs2340.homelessapp;

import org.junit.Before;
import org.junit.Test;

import edu.gatech.cs2340.homelessapp.Controllers.LoginActivity;
import edu.gatech.cs2340.homelessapp.Model.HomelessUser;
import edu.gatech.cs2340.homelessapp.Model.Users;

import static org.junit.Assert.assertEquals;

/**
 * Created by Sidharth on 4/9/2018.
 */

public class IsPasswordValidTest {

    private final LoginActivity loginActivity = new LoginActivity();

    private final String validEmail = "a";
    private final String validPassword = "a";
    private final String invalidEmail = "b";
    private final String invalidPassword = "b";

    @Before
    public void setUp() {}

    @Test
    public void testValidEmailAndValidPassword(){
        assertEquals(true, !loginActivity.isPasswordValid(validEmail, validPassword));
    }

    @Test
    public void testValidEmailAndInvalidPassword(){
        assertEquals(false, loginActivity.isPasswordValid(validEmail, invalidPassword));
    }

    @Test
    public void testInvalidEmailAndValidPassword(){
        assertEquals(false, loginActivity.isPasswordValid(invalidEmail, invalidPassword));
    }

    @Test
    public void testInvalidEmailAndInvalidPassword() {
        assertEquals(false, loginActivity.isPasswordValid(invalidEmail, invalidPassword));
    }

}
