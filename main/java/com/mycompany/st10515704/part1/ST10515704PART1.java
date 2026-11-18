/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.st10515704.part1;

import java.util.ArrayList;
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
                     
            
             MessageManager manager = new MessageManager();
    manager.loadTestData();

    boolean running = true;
    
     //While loop
            while (running) {
                System.out.println("\nMenu:");
                System.out.println("1) Send Messages");
                System.out.println("2) Show recently sent messages");
                System.out.println("3) Quit");
                System.out.println("4) Stored Messages");
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
                       Message msg1 = new Message("1000000001",1,"+27718693002", "Hi Mike, can you join us for dinner tonight?", "00:00:HITONIGHT");
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
                               Message currentMessage = new Message( "100000000" + (i + 1), i + 1, recipient, messageText, "HASH" + (i + 1));

                             if (option == 1)
                             {manager.addSentMessage(currentMessage);}
                                else if (option == 2) {manager.addDisregardedMessage(currentMessage);}
                                else if (option == 3) {manager.addStoredMessage(currentMessage);}
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
                    case 4: int storedOption;

                    do {
 System.out.println("\n===== STORED MESSAGES MENU =====");
                        System.out.println("1. Display Stored Messages");
                        System.out.println("2. Display Longest Stored Message");
                        System.out.println("3. Search Message by ID");
                        System.out.println("4. Search Messages by Recipient");
                        System.out.println("5. Delete Message by Hash");
                        System.out.println("6. Display Report");
                        System.out.println("7. Back");
                        System.out.print("Choose an option: ");

                        storedOption = kb.nextInt();
                        kb.nextLine();

                        switch (storedOption) {

                            case 1:

                                manager.displayStoredMessages();
                                break;

                            case 2:

                                System.out.println(
                                        manager.displayLongestStoredMessage());
                                break;

                            case 3:

                                System.out.print("Enter Message ID: ");
                                String id = kb.nextLine();

                                Message found =
                                        manager.searchByMessageID(id);

                                if (found != null) {

                                    System.out.println(
                                            "Recipient: "
                                                    + found.getRecipient());

                                    System.out.println(
                                            "Message: "
                                                    + found.getMessageText());

                                } else {

                                    System.out.println(
                                            "Message ID not found.");
                                }

                                break;

                            case 4:

                                System.out.print("Enter Recipient Number: ");
                                String recipient = kb.nextLine();

                                ArrayList<Message> messages =
                                        manager.searchByRecipient(recipient);

                                if (messages.isEmpty()) {

                                    System.out.println(
                                            "No messages found.");

                                } else {

                                    for (Message msg : messages) {

                                        System.out.println(
                                                msg.getMessageText());

                                        System.out.println(
                                                "------------------");
                                    }
                                }

                                break;

                            case 5:

                                System.out.print("Enter Message Hash: ");
                                String hash = kb.nextLine();

                                if (manager.deleteMessageByHash(hash)) {

                                    System.out.println(
                                            "Message deleted successfully.");

                                } else {

                                    System.out.println(
                                            "Hash not found.");
                                }

                                break;

                            case 6:

                                manager.displayReport();
                                break;

                            case 7:

                                System.out.println(
                                        "Returning to Main Menu...");
                                break;

                            default:

                                System.out.println(
                                        "Invalid option.");
                        } 
                } while (storedOption != 7);

                    break;

                   default:
                        System.out.println("Invalid choice. Please enter 1, 2, or 3.");
                }             }  
      }else { 
          System.out.println("Login Failed. Exiting the program");
      }
                   
       
       kb.close();
} 
     
    }
