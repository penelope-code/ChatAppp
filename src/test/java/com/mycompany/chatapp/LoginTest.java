/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.chatapp;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * 
 * @author Penelope
 */
public class LoginTest {
    
    private Login login;
    
    @BeforeEach
    void setUp() {
        login = new Login();
    }
    
    // ==================== assertEquals TESTS ====================
    
    /*
     * Test: Username is correctly formatted
     * Test Data: "kyl_1"
     * Expected: "Welcome <first name>, <last name> it is great to see you."
     */
    @Test
    void testUsernameCorrectlyFormatted() {
        String result = login.registerUser("kyl_1", "Ch&sec@ke99!", "+27838968976", "John", "Doe");
        assertTrue(result.contains("Username successfully captured"));
        assertTrue(result.contains("Password successfully captured"));
        assertTrue(result.contains("Cell phone number successfully added"));
    }
    
    /**
     * Test: Username incorrectly formatted
     * Test Data: "kyle!!!!!!!"
     * Expected: "Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length."
     */
    @Test
    void testUsernameIncorrectlyFormatted() {
        String result = login.registerUser("kyle!!!!!!!", "Ch&sec@ke99!", "+27838968976", "John", "Doe");
        assertTrue(result.contains("Username is not correctly formatted, please ensure that your username contains an underscore and is no more than five characters in length"));
    }
    
    /**
     * Test: Password meets complexity requirements
     * Test Data: "Ch&sec@ke99!"
     * Expected: "Password successfully captured."
     */
    @Test
    void testPasswordMeetsComplexity() {
        String result = login.registerUser("kyl_1", "Ch&sec@ke99!", "+27838968976", "John", "Doe");
        assertTrue(result.contains("Password successfully captured"));
    }
    
    /**
     * Test: Password does NOT meet complexity requirements
     * Test Data: "password"
     * Expected: "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character."
     */
    @Test
    void testPasswordDoesNotMeetComplexity() {
        String result = login.registerUser("kyl_1", "password", "+27838968976", "John", "Doe");
        assertTrue(result.contains("Password is not correctly formatted, please ensure that the password contains at least eight characters, a capital letter, a number, and a special character"));
    }
    
    /**
     * Test: Cell phone number correctly formatted
     * Test Data: "+27838968976"
     * Expected: "Cell number successfully captured."
     */
    @Test
    void testCellPhoneCorrectlyFormatted() {
        String result = login.registerUser("kyl_1", "Ch&sec@ke99!", "+27838968976", "John", "Doe");
        assertTrue(result.contains("Cell phone number successfully added"));
    }
    
    /**
     * Test: Cell phone number incorrectly formatted
     * Test Data: "08966553"
     * Expected: "Cell number is incorrectly formatted or does not contain an international code; please correct the number and try again."
     */
    @Test
    void testCellPhoneIncorrectlyFormatted() {
        String result = login.registerUser("kyl_1", "Ch&sec@ke99!", "08966553", "John", "Doe");
        assertTrue(result.contains("Cell phone number incorrectly formatted or does not contain international code"));
    }
    
    // ==================== assertTrue/assertFalse TESTS ====================
    
    /**
     * Test: Login Successful
     * Expected: returns True
     */
    @Test
    void testLoginSuccessful() {
        login.registerUser("kyl_1", "Ch&sec@ke99!", "+27838968976", "John", "Doe");
        boolean result = login.loginUser("kyl_1", "Ch&sec@ke99!");
        assertTrue(result);
    }
    
    /**
     * Test: Login Failed
     * Expected: returns False
     */
    @Test
    void testLoginFailed() {
        login.registerUser("kyl_1", "Ch&sec@ke99!", "+27838968976", "John", "Doe");
        boolean result = login.loginUser("kyl_1", "wrongpassword");
        assertFalse(result);
    }
    
    /**
     * Test: Username correctly formatted
     * Expected: returns True
     */
    @Test
    void testCheckUsernameCorrect() {
        boolean result = login.checkUsername("kyl_1");
        assertTrue(result);
    }
    
    /**
     * Test: Username incorrectly formatted
     * Expected: returns False
     */
    @Test
    void testCheckUsernameIncorrect() {
        boolean result = login.checkUsername("kyle!!!!!!!");
        assertFalse(result);
    }
    
    /**
     * Test: Password meets complexity requirements
     * Expected: returns True
     */
    @Test
    void testCheckPasswordComplexityCorrect() {
        boolean result = login.checkPasswordComplexity("Ch&sec@ke99!");
        assertTrue(result);
    }
    
    /**
     * Test: Password does NOT meet complexity requirements
     * Expected: returns False
     */
    @Test
    void testCheckPasswordComplexityIncorrect() {
        boolean result = login.checkPasswordComplexity("password");
        assertFalse(result);
    }
    
    /**
     * Test: Cell phone number correctly formatted
     * Expected: returns True
     */
    @Test
    void testCheckCellPhoneNumberCorrect() {
        boolean result = login.checkCellPhoneNumber("+27838968976");
        assertTrue(result);
    }
    
    /**
     * Test: Cell phone number incorrectly formatted
     * Expected: returns False
     */
    @Test
    void testCheckCellPhoneNumberIncorrect() {
        boolean result = login.checkCellPhoneNumber("08966553");
        assertFalse(result);
    }
}
