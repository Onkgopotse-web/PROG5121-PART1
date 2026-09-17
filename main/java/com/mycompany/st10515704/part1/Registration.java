package com.mycompany.st10515704.part1;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author kyrah
 */
public class Registration {
    private String Username;
    private String Password;
    private String phoneNumber;
    private String firstName;
    private String lastName;
                  //Constructor for Registration
            public Registration(String Username,String Password,String phoneNumber, String firstName, String lastName){
               this.Username = Username;
               this.Password = Password;
               this.phoneNumber = phoneNumber;
               this.firstName =firstName;
               this.lastName = lastName;
            }
            // Check Username
            public String checkUsername(){
                if(Username.contains("_") && Username.length()<=5){
                    return "Welcome " + firstName + "," + lastName + " it is great to see you!";
                }else{
                    return "Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.";
                }
            }
            // Check Password
            public String checkPassword(){
                boolean hasUpper = !Password.equals(Password.toLowerCase());
                boolean hasNumber = Password.matches(".*\\d.*");
                boolean hasSpecial = Password.matches(".*[!@#$%^&*].*");
                
                 if (Password.length()>=8 && hasUpper && hasNumber && hasSpecial){
                     return "Password successfully captured.";
                 }else {
                     return "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";
                 }
            }
       //1(b) Check cell phone number format using regular expression
public String checkCellPhoneNumber() {
    // Regex pattern: starts with +27 followed by 9 digits (total 12 characters)
    // Reference: W3Schools Java Regex examples
    if (phoneNumber.matches("\\+27\\d{9}")) {
        return "Cell phone number successfully added.";
    } else {
        return "Cell phone number incorrectly formatted or does not contain an international code; please correct the number and try again.";
    }
}
 }
                