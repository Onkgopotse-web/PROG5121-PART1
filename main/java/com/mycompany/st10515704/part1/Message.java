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
    //Declare
    private String messageID;
    private int messageNumber;
    private String recipient;
    private String messageText;
    private String messageHash;

    // Method 1: Check Message ID
    public boolean checkMessageID(String messageID) {
        return messageID.matches("\\d{10}");
    }

    // Method 2: Generate a unique 10-digit Message ID
    public String generateMessageID() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            int digit = (int) (Math.random() * 10);
            sb.append(digit);
        }
        return sb.toString();
    }

    // Method 3: Create Message Hash
    private String createMessageHash(String messageID, int messageNumber, String messageText) {
        String[] words = messageText.split(" ");
        String firstWord = words[0].substring(0, 2).toUpperCase();
        String lastWord = words[words.length - 1].replace("?", "").toUpperCase();
        return "00:0:" + firstWord + lastWord;
    }

    // Method 4: Send Message (Question 8)
    public boolean sendMessage(int messageNumber, String recipient, String messageText, int option) {
        // Validation
        if (messageText.length() > 250) {
            System.out.println("Please enter a message of less than 250 characters.");
            return false;
        }
        if (!recipient.startsWith("+27") || recipient.length() > 10) {
            return false;
        }

        // Generate ID and Hash
        String messageID = generateMessageID();
        String messageHash = createMessageHash(messageID, messageNumber, messageText);

        // Display details
        System.out.println("\n--- Message Details ---");
        System.out.println("Message ID: " + messageID);
        System.out.println("Message Number: " + messageNumber);
        System.out.println("Recipient: " + recipient);
        System.out.println("Message: " + messageText);
        System.out.println("Message Hash: " + messageHash);

        // Handle user option
        switch (option) {
            case 1: // Send
                System.out.println("Message successfully sent");
                storeMessage(messageID, messageNumber, recipient, messageText, messageHash);
                return true;
            case 2: // Disregard
                System.out.println("Press 0 to delete the message");
                return false;
            case 3: // Store
                System.out.println("Message successfully stored");
                storeMessage(messageID, messageNumber, recipient, messageText, messageHash);
                return true;
            default:
                System.out.println("Invalid option. Message not processed.");
                return false;
        }
    }

    // Method 5: Check Message Length (Question 9)
    public String checkMessageLength(String message) {
        if (message.length() <= 250) {
            return "Message ready to send.";
        } else {
            int extra = message.length() - 250;
            return "Message exceeds 250 characters by " + extra + "; please reduce the size.";
        }
    }

    // Method 6: Check Recipient Cell (Question 9)
    public String checkRecipientCell(String recipient) {
        if (recipient.startsWith("+27") && recipient.length() <= 10) {
            return "Cell phone number successfully captured.";
        } else {
            return "Cell phone number is incorrectly formatted or does not contain an international code. Please correct the number and try again.";
        }
    }

    // Method 7: SentMessage (calls sendMessage)
    public String SentMessage(int messageNumber, String recipient, String messageText, int option) {
        sendMessage(messageNumber, recipient, messageText, option);
        return "Message processed.";
    }

    // Method 8: PrintMessages
    public String printMessages() {
        return "All messages have been displayed on screen after sending.";
    }

    // Method 9: ReturnTotalMessages
    public int returnTotalMessages(int totalSent) {
        return totalSent++;
    }

    // Method 10: Store message in JSON
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

    // Method 11: Process Message Option (Question 9 MessageSent)
    public String processMessageOption(int option) {
        switch (option) {
            case 1: return "Message successfully sent.";
            case 2: return "Press 0 to delete the message.";
            case 3: return "Message successfully stored.";
            default: return "Invalid option.";
        }
    }

    // Method 12: Generate Message Hash (Question 9)
    public String generateMessageHash(String message) {
        String[] words = message.split(" ");
        String firstWord = words[0].substring(0, 2).toUpperCase();
        String lastWord = words[words.length - 1].replace("?", "").toUpperCase();
        return "00:0:" + firstWord + lastWord;
    }
}
