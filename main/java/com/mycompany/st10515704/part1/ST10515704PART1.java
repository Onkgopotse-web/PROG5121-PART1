/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.st10515704.part1;

import java.util.Scanner;

/**
 *
 * @author kyrah
 */
public class ST10515704PART1 {

    public static void main(String[] args) {
        //Create Scanner Object
        Scanner kb = new Scanner(System.in);
        
             // Registration Phase
             //User Iput
             System.out.println("Enter your Username:");
             String Username = kb.nextLine();
               System.out.println("Enter your Password:");
             String Password = kb.nextLine();
               System.out.println("Enter your Cell Phone Number:");
             String phoneNumber = kb.nextLine();
             
             //Login phase
             //User input              
             System.out.println("Enter your First Name:");
             String firstName = kb.nextLine();
              System.out.println("Enter your Last Name:");
             String lastName = kb.nextLine();
             
             
       //Create Registration Object     
       Registration reg1= new Registration(Username,Password,phoneNumber,firstName,lastName);
         System.out.println(reg1.checkUsername());
         System.out.println(reg1.checkPassword());
         System.out.println(reg1.checkCellPhoneNumber());
         
         // Using getters to read values = Encapsulation
         System.out.println("Stored Username: " + reg1.getUsername());
         System.out.println("Stored First Name: " + reg1.getFirstName());
         System.out.println("Stored Cell Phone Number: " + reg1.getPhoneNumber());
         
            //Create Login Object
            Login log1 = new Login(Username, Password, phoneNumber, firstName, lastName);
            //Registration result
              System.out.println(log1.registerUser());
              // Display stored login details using getters
                System.out.println("Stored Username: " + log1.getUsername());
                System.out.println("Stored Password: " + log1.getPassword());
                System.out.println("Stored Cell Phone Number: " + log1.getPhoneNumber());
                System.out.println("Stored First Name: " + log1.getFirstName());
                System.out.println("Stored Last Name: " + log1.getLastName());
                
                
         //Login Phase
       System.out.println("\n===Login===");
       System.out.println("Enter Username:");
       String enteredUsername = kb.nextLine();
       
            System.out.println("Enter Password:");
       String enteredPassword = kb.nextLine();
       
       //Verify Login
       boolean loginSuccess = log1.loginUser(enteredUsername, enteredPassword);
       System.out.println(log1.returnLoginStatus(loginSuccess));
       
       kb.close();
    }      
    
     
}
