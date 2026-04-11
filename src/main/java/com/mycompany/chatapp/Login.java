/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.chatapp;

/**
 * 
 * @author Penelope
 */

class Login {//start of class
    

    // Private variables to store user registration data (Encapsulation)
    private String storedUsername;     
    private String storedPassword;      
    private String storedPhoneNumber;   
    private String firstName;           
    private String lastName;            
    

    
    //boolean method to check if username contains an underscore (_) and is maximum 5 characters long
    public boolean checkUsername(String username){//start of method
        
        // Check if username contains underscore AND length is 5 or less
        if(username.contains("_") && username.length() <= 5) {//start of ifelse statement
            
            return true;   // Username meets all requirements  
        } else {      
            return false;  // Username does not meet requirements
        } //end of ifelse statement  
        
    }//end of method
    

    /*
     * Boolean method to check if password meets all complexity requirements:
     * - At least 8 characters long
     * - Contains at least 1 capital letter (A-Z)
     * - Contains at least 1 lowercase letter (a-z)
     * - Contains at least 1 number (0-9)
     * - Contains at least 1 special character
     */
    public boolean checkPasswordComplexity(String password){//start of method
        
        if(password.length() >= 8 &&                    
           password.matches(".*[A-Z].*") &&             
           password.matches(".*[a-z].*") &&              
           password.matches(".*[0-9].*") &&              
           password.matches(".*[!@#$%^&*()_+{}<>?=/].*")) { 
            
            return true;   // Password meets all complexity requirements
             
        } else {
            return false;  // Password fails one or more requirements
        }
        
    }//end of method
    
    /*
     * Validates South African cell phone number format
     * Requirements:
     * - Must start with +27 (international code for South Africa)
     * - Must have exactly 9 digits after the country code
     */
    public boolean checkCellPhoneNumber(String phoneNumber){//start of method
        
        // Check if phoneNumber is null (no input)
        if(phoneNumber == null){
            return false;  // Null value is invalid
        }
        
        // Check if the number starts with +27 (South Africa country code)
        // .startsWith() returns true if string begins with specified characters
        if(!phoneNumber.startsWith("+27")){
            return false;  // Missing or incorrect country code
        }
        
        // Extract the part after +27 using substring
        String numberAfterCode = phoneNumber.substring(3);
        
        // Check if the remaining number has exactly 9 digits
        // South African cell numbers are 9 digits after +27
        if(numberAfterCode.length() != 9){
            return false;  // Wrong number of digits
        }
        
        // For loop to verify every character after +27 is a digit
        for(int i = 0; i < numberAfterCode.length(); i++){
            char c = numberAfterCode.charAt(i);
            
            // Check if character is NOT a digit (0-9)
            if(c < '0' || c > '9'){
                return false;  // Found a non-digit character
            }
        }
        
        return true;  // All validation checks passed
    }//end of method
    

     /*Registers a new user if all validation checks pass
     * Stores user information in class variables
     * Returns appropriate success or error messages
     */
    public String registerUser(String username, String password, String phoneNumber, 
                               String firstName, String lastName){//start of method
        
        // Call validation methods to check each field
        boolean isUsernameValid = checkUsername(username);   
        boolean isPasswordValid = checkPasswordComplexity(password); 
        boolean isPhoneValid = checkCellPhoneNumber(phoneNumber);  
        
        String message = "";  // Initialize empty message string
        
        // IF ALL three validations pass
        if(isUsernameValid && isPasswordValid && isPhoneValid){
            
            // Store all registration information in class variables
            this.storedUsername = username;
            this.storedPassword = password;
            this.storedPhoneNumber = phoneNumber;
            this.firstName = firstName;          
            this.lastName = lastName;         
        
            // Build success message with line breaks (\n creates new line)
            message = "Username successfully captured.\n";
            message = message + "Password successfully captured\n";
            message = message + "Cell phone number successfully added\n";
            message = message + "Registration complete";
            
        } else {
            
            // Check username - show error if INVALID (! means NOT)
            if(!isUsernameValid){  
                message = "Username is not correctly formatted, please ensure that your username contains"
                        + " an underscore and is no more than five characters in length.\n";
            }
        
            // Check password - show error if INVALID
            if(!isPasswordValid){  
                // Add to existing message using concatenation (+= could also be used)
                message = message + "Password is not correctly formatted, please ensure that the password"
                        + " contains at least eight characters, a capital letter, a number, and a special character.\n";
            }
        
            // Check phone - show error if INVALID
            if(!isPhoneValid){  
                message = message + "Cell phone number incorrectly formatted or does not contain international code.\n";
            }
        }
        
        return message;  // Return the final status message
    }// end of method
    
    //method to Compare entered credentials with stored credentials using .equals()
    public boolean loginUser(String username, String password){//start of method
        
        // .equals() compares the actual string content, not object references
        if(username.equals(storedUsername) && password.equals(storedPassword)){
            
            return true;  // Login successful - credentials match
            
        } else {
            return false; // Login failed - credentials don't match
        }
    }//end of method
    
    
    // method to return appropriate message based on login success or failure
    public String returnLoginStatus(boolean loginSuccess){//start of method
        
        // Check if login was successful
        if(loginSuccess){
            // Successful login - return personalized welcome message
            // firstName and lastName were stored during registration
            return "Welcome back " + firstName + " " + lastName + ", it's great to see you again.";
            
        } else {
            // Failed login - return generic error message
            return "Username of password incorrect, please try again. ";
        }
    }//end of method
    
    
    //Getter methods to provide controlled access to private variables

    public String getStoredUsername(){//start of method
        return storedUsername;  // Return the stored username
    }//end of method
    
    public String getStoredPassword(){//start of method
        return storedPassword;  // Return the stored password
    }//end of method
    
    public String getStoredPhoneNumber(){//start of method
        return storedPhoneNumber;  // Return the stored phone number
    }//end of method
    
    public String getFirstName(){//start of method
        return firstName;  // Return user's first name
    }//end of method
    
    public String getLastName(){//start of method
        return lastName;  // Return user's last name
    }//end of method
        
}//end of class