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
       
       
       
       ////PART 2
      //(1&2)Only proceed if login succeded
      if (loginSuccess) {
            System.out.println("Welcome to QuickChat.");
      
     //Part 2 Menu
     boolean running = true;
     //While loop
            while (running) {
                System.out.println("\nMenu:");
                System.out.println("1) Send Messages");
                System.out.println("2) Show recently sent messages (Coming Soon)");
                System.out.println("3) Quit");
                System.out.print("Enter your choice: ");
                   
                 int choice =kb.nextInt();
                 kb.nextLine(); //consume newLine
                //menu logic will follow here(Q3&4)
                switch (choice) {
                    case 1:
                        System.out.println("You selected: Send Messages");
                        
                        // Message sending logic will go here (Part 2 continuation)
                        System.out.println("How many messages do you want to send? ");
                        int numMessages = kb.nextInt();
                        kb.nextLine(); // consume newLine
                        
                        //Create Message Object
                        Message msg1 = new Message();
                        int totalSent = 0;
                        
                        // For loop
                        for(int i = 0; i< numMessages; i++){
                            System.out.println("\nMessage " + (i + 1) + ":");
                            System.out.print("Enter recipient number: ");
                             String recipient = kb.nextLine();
                           System.out.print("Enter message text: ");
                              String messageText = kb.nextLine(); 
                            System.out.println("Choose an option: 1) Send  2) Disregard  3) Store");
                            int option = kb.nextInt();
                            kb.nextLine(); // consume newline
                            
                       if (msg1.sendMessage(i + 1, recipient, messageText, option)) {
                              totalSent++;
                             }
                        }
                        System.out.println("Total messages successfully sent: " + totalSent); 
                        break;

                    case 2:
                        System.out.println("Coming Soon.");
                        break;

                    case 3:
                        System.out.println("Goodbye!");
                        running = false;
                        break;

                    default:
                        System.out.println("Invalid choice. Please enter 1, 2, or 3.");
                }
            }
      } else { 
          System.out.println("Login Failed. Exiting the program");
      }
  
                      
       
       kb.close();
    }      
    
     
}
