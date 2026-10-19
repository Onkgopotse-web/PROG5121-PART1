/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.st10515704.part1;
import java.util.Random;
import org.json.simple.JSONObject;
import java.io.FileWriter;
import java.io.IOException;
/**
 *
 * @author kyrah
 */
public class Message {
    private String messageID;
    private int messageNumber;
    private String recipient;
    private String messageText;
    private String messageHash;
    
    
    // Method to generate a unique 10-digit Message ID
    private String generateMessageID() {
        long id = (long)(Math.random() * 1_000_000_0000L);
        return String.format("%010d", id);
    }
     // Create Message Hash
    private String createMessageHash(String messageID, int messageNumber, String messageText) {
        String[] words = messageText.split(" ");
        String firstWord = words[0];
        String lastWord = words[words.length - 1];
        
        // First two digits of ID + message number + first/last words
        String hash = messageID.substring(0, 2) + ":" + messageNumber + ":" + firstWord + ":" + lastWord;
        return hash.toUpperCase();
    }
   
    // Declaration of sendMessage method
    public boolean sendMessage(int messageNumber, String recipient, String messageText, int option) {
        // Section 1 logic: Recipient validation
        if (!recipient.matches("\\+27\\d{9}")) {
            System.out.println("Invalid recipient number. Must start with +27 and be followed by 9 digits (total 12 characters).");
            return false;
        }
        
     //  Message length validation
        if (messageText.length() > 250) {
            System.out.println("Please enter a message of less than 250 characters.");
            return false;
        }
        
// Generate unique Message ID and Message Hash
        String messageID = generateMessageID();
String messageHash = createMessageHash(messageID, messageNumber, messageText);
        
// Display details
       System.out.println("\n--- Message Details ---");
        System.out.println("Message ID: " + messageID);
        System.out.println("Message Number: " + messageNumber);
        System.out.println("Recipient: " + recipient);
        System.out.println("Message: " + messageText);
        System.out.println("Message Hash: " + messageHash);
        
         //  Handle user option
        switch (option) {
            case 1: // Send Message
                System.out.println("Message successfully sent");
                storeMessage(messageID, messageNumber, recipient, messageText, messageHash);
                return true;

            case 2: // Disregard Message
                System.out.println("Press 0 to delete the message");
                return false;

            case 3: // Store Message for later
                System.out.println("Message successfully stored");
                storeMessage(messageID, messageNumber, recipient, messageText, messageHash);
                return false;

            default:
                System.out.println("Invalid option. Message not processed.");
                return false;
        }
    }
    //  Method 1: Check Message ID
    public boolean checkMessageID(String messageID) {
        return messageID.length() <= 10;
    }

    // Method 2: Check Recipient Cell
    public String checkRecipientCell(String recipient) {
        if (recipient.length() <= 10 && recipient.startsWith("+")) {
            return "Valid recipient cell number.";
        } else {
            return "Invalid recipient cell number: must start with a code and be no more than 10 characters.";
        }
    }
  
    //  Method 4: SentMessage (calls sendMessage)
    public String SentMessage(int messageNumber, String recipient, String messageText, int option) {
        sendMessage(messageNumber, recipient, messageText, option);
        return "Message processed.";
    }

    // Method 5: PrintMessages (placeholder for displaying all messages)
    public String printMessages() {
        return "All messages have been displayed on screen after sending.";
    }

    // Method 6: ReturnTotalMessages
    public int returnTotalMessages(int totalSent) {
        return totalSent;
    }
    
    // Method 7: Store message in JSON file
    private void storeMessage(String messageID, int messageNumber, String recipient, String messageText, String messageHash) {
        JSONObject obj = new JSONObject();
        obj.put("MessageID", messageID);
        obj.put("MessageNumber", messageNumber);
        obj.put("Recipient", recipient);
        obj.put("Message", messageText);
        obj.put("MessageHash", messageHash);

        try (FileWriter file = new FileWriter("messages.json", true)) {
            file.write(obj.toJSONString() + "\n");
        } catch (IOException e) {
            System.out.println("Error writing to JSON file: " + e.getMessage());
        }
    }
}

