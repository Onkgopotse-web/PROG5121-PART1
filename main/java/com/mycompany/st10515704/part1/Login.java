package com.mycompany.st10515704.part1;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author kyrah
 */
public class Login {
    //Declare and make the atrributes private = meaning they are not accesible easily by the public
    private String Username;
    private String Password;
    private String phoneNumber;
    private String firstName;
    private String lastName;
    
      // Constructor
      public Login(String Username, String Password, String phoneNumber, String firstName, String lastName){
          this.Username = Username;
          this.Password = Password;
          this.phoneNumber = phoneNumber;
          this.firstName = firstName;
          this.lastName = lastName;
      }
      // Verify the Username and Password entered 
      public String VerifyUser(String enteredUsername, String enteredPassword){
          if (enteredUsername.equals(Username)&& enteredPassword.equals(Password)){
              return "Welcome" +firstName + "," + lastName+ "it is great to see you again";
          }else {
              return "Username or Password incorrect, please TRY AGAIN";
          }
      }
      //checkUsername() :Boolean
      public boolean checkUsername(){
          return Username.contains("_") && Username.length()<=5;
      }
        //Boolean: checkPasswordComplexity
      public boolean checkPasswordComplexity(){
           boolean hasUpper = !Password.equals(Password.toLowerCase());
           // Reference: W3Schools Java Regex examples 
           boolean hasNumber = Password.matches(".*\\d.*");
           boolean hasSpecial = Password.matches(".*[!@#$%^&*].*");
             return Password.length()>=8 && hasUpper && hasNumber && hasSpecial;
      }
      
      //Boolean: checkPhoneNumber()
      public boolean checkPhoneNumber(){
   // Regex pattern: starts with +27 followed by 9 digits (total 12 characters)
    // Reference: W3Schools Java Regex examples          
    return phoneNumber.matches("\\+27\\d{9}");
      }
      // String: registerUser()
      public String registerUser() {
        if (!checkUsername()) {
            return "Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.";
        } else if (!checkPasswordComplexity()) {
            return "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";
        } else {
            return "User registered successfully.";
        }
      }
      
      //  Boolean: loginUser()
    public boolean loginUser(String enteredUsername, String enteredPassword) {
        return enteredUsername.equals(Username) && enteredPassword.equals(Password);
    }
    
    //String :returnLoginStatus
     public String returnLoginStatus(boolean loginSuccess) {
        if (loginSuccess) {
            return "Welcome " + firstName + ", " + lastName + " it is great to see you again.";
        } else {
            return "Username or password incorrect, please try again.";
        }
     }
     
}
