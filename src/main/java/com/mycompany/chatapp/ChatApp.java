/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.chatapp;

import java.util.Scanner;

/**
 * 
 * @author Penelope
 */
public class ChatApp {//start of class

    public static void main(String[] args) {//start of main method
        
        // Create a Scanner object to read user input from the console
        Scanner scanner = new Scanner(System.in);
        
        // Creating an instance of the Login class to access its methods
        Login myLogin = new Login();
        
        // Displaying welcome message
        System.out.println("=".repeat(50));
        System.out.println("     WELCOME TO THE CHAT APPLICATION");
        System.out.println("=".repeat(50));
        System.out.println();  
        
        // ==================== REGISTRATION ====================
        System.out.println("--- REGISTRATION ---");
        System.out.println();
        
        // Prompting the user to enter their first name
        System.out.print("Please enter your first name: ");
        String firstName = scanner.nextLine(); 
        
        // Prompting the user to enter their last name
        System.out.print("Please enter your last name: ");
        String lastName = scanner.nextLine(); 
        
        // Initializing empty username string
        String username = "";  
        
        // Flag to track if username is valid
        boolean validUsername = false;  
        
        // While loop continues until user enters a valid username
        while(!validUsername) {
            System.out.print("Create username (must contain _ and be max 5 chars): ");
            username = scanner.nextLine();  
            
            // Calling checkUsername method to validate the username
            if(myLogin.checkUsername(username)) {
                validUsername = true;  
            } else {
                // Displaying error message and continue the loop
                System.out.println("Error: Username must contain an underscore (_) and be no more than 5 characters long.");
            }
        }
        
        // Initializing empty password string
        String password = ""; 
        
        // Flag to track if password is valid
        boolean validPassword = false;  
        
        // While loop continues until user enters a valid password
        while(!validPassword) {
            System.out.println("Create password (must have: 8+ chars, 1 capital, 1 number, 1 special character): ");
            System.out.print("Password: ");
            password = scanner.nextLine(); 
            
            // Calling checkPasswordComplexity method to validate the password
            if(myLogin.checkPasswordComplexity(password)) {
                validPassword = true;  
            } else {
                // Display detailed password requirements
                System.out.println("Your password must include the following:");
                System.out.println("  - At least 8 characters");
                System.out.println("  - At least 1 capital letter (A-Z)");
                System.out.println("  - At least 1 number (0-9)");
                System.out.println("  - At least 1 special character (!@#$%^&* etc.)\n");
            }
        }
        
        // Initializing empty phone number string
        String phoneNumber = "";  
        boolean validPhone = false;  // Flag to track if phone number is valid
        
        // While loop continues until user enters a valid phone number
        while(!validPhone) {
            System.out.print("Enter South African cell number (format: +27XXXXXXXXX): ");
            phoneNumber = scanner.nextLine();  // Read phone number input
            
            // Calling checkCellPhoneNumber method to validate the phone number
            if(myLogin.checkCellPhoneNumber(phoneNumber)) {
                validPhone = true;  
            } else {
                // Displaying error message with correct format example
                System.out.println("Error: Cell number must start with +27 and have 9 digits after.");
            }
        }
        
        System.out.println(); 
        
        //registering the user with all collected information
        String registrationResult = myLogin.registerUser(username, password, phoneNumber, firstName, lastName);
        
        // Displaying registration result
        System.out.println(registrationResult);  
        
        // Checking if registration was successful by verifying stored username is not null
        boolean isRegistered = (myLogin.getStoredUsername() != null);
        
        if(isRegistered) {
            // Registration successful - proceed to login phase
            System.out.println("\nRegistration completed successfully!\n");
            
            // ==================== LOGIN ====================
            System.out.println("--- LOGIN ---");
            System.out.println();
            
            boolean loginSuccess = false;  // Flag to track if login is successful
            int attempts = 0;  // Counter for login attempts
            int maxAttempts = 3;  // Maximum allowed login attempts
            
            // While loop allows up to 3 login attempts
            while(!loginSuccess && attempts < maxAttempts) {
                System.out.print("Enter username: ");
                String loginUsername = scanner.nextLine();  // Read username for login
                
                System.out.print("Enter password: ");
                String loginPassword = scanner.nextLine();  // Read password for login
                
                // Calling loginUser method to verify credentials
                loginSuccess = myLogin.loginUser(loginUsername, loginPassword);
                
                if(loginSuccess) {
                    // Login successful - display welcome message
                    System.out.println();
                    System.out.println("=".repeat(50));
                    System.out.println(myLogin.returnLoginStatus(loginSuccess));
                    System.out.println("=".repeat(50));
                } else {
                    // Login failed
                    attempts++;
                    if(attempts < maxAttempts) {
                        System.out.println("Username or password incorrect, please try again.");
                        System.out.println("Attempts remaining: " + (maxAttempts - attempts) + "\n");
                    }
                }
            }
            
            // If all attempts fail, display lockout message
            if(!loginSuccess) {
                System.out.println("\nYou have reached the maximum login attempts.");
            }
            
        } else {
            // Registration failed
            System.out.println("\nRegistration failed. Please restart the application and try again.");
        }
        
        scanner.close();
    }//end of main method
    
}//end of ChatApp class