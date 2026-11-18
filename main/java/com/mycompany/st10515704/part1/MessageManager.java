package com.mycompany.st10515704.part1;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.ArrayList;
/**
 *
 * @author kyrah
 */
public class MessageManager {
     private ArrayList<Message> sentMessages;
    private ArrayList<Message> storedMessages;
    private ArrayList<Message> disregardedMessages;

    private ArrayList<String> messageIDs;
    private ArrayList<String> messageHashes;
    
    public MessageManager() {
        sentMessages = new ArrayList<>();
        storedMessages = new ArrayList<>();
        disregardedMessages = new ArrayList<>();

        messageIDs = new ArrayList<>();
        messageHashes = new ArrayList<>();
    }
    
    //QUESTION 1
    public void addSentMessage(Message message) {
        sentMessages.add(message);

        messageIDs.add(message.getMessageID());
        messageHashes.add(message.getMessageHash());
    }

    public void addStoredMessage(Message message) {
        storedMessages.add(message);

        messageIDs.add(message.getMessageID());
        messageHashes.add(message.getMessageHash());
    }

    public void addDisregardedMessage(Message message) {

    disregardedMessages.add(message);

    messageIDs.add(message.getMessageID());
    messageHashes.add(message.getMessageHash());
}

    // ============================
    // QUESTION 2(a)
    // ============================

    public void displayStoredMessages() {

        if (storedMessages.isEmpty()) {
            System.out.println("No stored messages.");
            return;
        }

        for (Message msg : storedMessages) {

            System.out.println("Recipient: "
                    + msg.getRecipient());

            System.out.println("Message: "
                    + msg.getMessageText());

            System.out.println("---------------------");
        }
    }

   
    // QUESTION 2(b)
    

    public String displayLongestStoredMessage() {

        if (storedMessages.isEmpty()) {
            return "No stored messages.";
        }

        Message longest = storedMessages.get(0);

        for (Message msg : storedMessages) {

            if (msg.getMessageText().length()
                    > longest.getMessageText().length()) {

                longest = msg;
            }
        }

        return longest.getMessageText();
    }

    
    // QUESTION 2(c)
  
    public Message searchByMessageID(String id) {

        for (Message msg : sentMessages) {

        if (msg.getMessageID().equals(id)) {
            return msg;
        }
    }

    for (Message msg : storedMessages) {

        if (msg.getMessageID().equals(id)) {
            return msg;
        }
    }

    for (Message msg : disregardedMessages) {

        if (msg.getMessageID().equals(id)) {
            return msg;
            }
        }

        return null;
    }

    
    // QUESTION 2(d)
   

    public ArrayList<Message> searchByRecipient(String recipient) {

        ArrayList<Message> foundMessages =
                new ArrayList<>();

        for (Message msg : storedMessages) {

            if (msg.getRecipient().equals(recipient)) {
                foundMessages.add(msg);
            }
        }

        return foundMessages;
    }

    
    // QUESTION 2(e)
    

    public boolean deleteMessageByHash(String hash) {

        for (int i = 0; i < storedMessages.size(); i++) {

            Message msg = storedMessages.get(i);

            if (msg.getMessageHash().equals(hash)) {

                storedMessages.remove(i);
                messageHashes.remove(hash);

                return true;
            }
        }

        return false;
    }

    
    // QUESTION 2(f)
    

    public void displayReport() {

        if (sentMessages.isEmpty()) {

            System.out.println("No sent messages found.");
            return;
        }

        for (Message msg : sentMessages) {

            System.out.println("Message ID: "
                    + msg.getMessageID());

            System.out.println("Message Hash: "
                    + msg.getMessageHash());

            System.out.println("Recipient: "
                    + msg.getRecipient());

            System.out.println("Message: "
                    + msg.getMessageText());

            System.out.println(
                    "--------------------------------");
        }
    }
public String generateReport() {

    StringBuilder report = new StringBuilder();

    if (sentMessages.isEmpty()) {
        return "No sent messages found.";
    }

    for (Message msg : sentMessages) {

        report.append("Message ID: ")
              .append(msg.getMessageID())
              .append("\n");

        report.append("Message Hash: ")
              .append(msg.getMessageHash())
              .append("\n");

        report.append("Recipient: ")
              .append(msg.getRecipient())
              .append("\n");

        report.append("Message: ")
              .append(msg.getMessageText())
              .append("\n");

        report.append("--------------------------------\n");
    }

    return report.toString();
}

    //GETTERS
      public ArrayList<Message> getSentMessages() {
        return sentMessages;
    }

    public ArrayList<Message> getStoredMessages() {
        return storedMessages;
    }

    public ArrayList<Message> getDisregardedMessages() {
        return disregardedMessages;
    }

    public ArrayList<String> getMessageIDs() {
        return messageIDs;
    }

    public ArrayList<String> getMessageHashes() {
        return messageHashes;
    }

public void loadTestData() {

    // Message 1 - Sent
    Message msg1 = new Message(
            "1000000001",
            1,
            "+27834557896",
            "Did you get the cake?",
            "00:00:DICAKE");

    addSentMessage(msg1);

    // Message 2 - Stored
    Message msg2 = new Message(
            "1000000002",
            2,
            "+27838884567",
            "Where are you? You are late! I have asked you to be on time.",
            "00:00:WHETIME");

    addStoredMessage(msg2);

    // Message 3 - Disregarded
    Message msg3 = new Message(
            "1000000003",
            3,
            "+27834484567",
            "Yohoooo, I am at your gate.",
            "00:00:YOOGATE");

    addDisregardedMessage(msg3);

    // Message 4 - Sent
    Message msg4 = new Message(
            "1000000004",
            4,
            "0838884567",
            "It is dinner time!",
            "00:00:ITTIME");

    addSentMessage(msg4);

    // Message 5 - Stored
    Message msg5 = new Message(
            "1000000005",
            5,
            "+27838884567",
            "Ok, I am leaving without you.",
            "00:00:OKYOU");

    addStoredMessage(msg5);
    
}

  
  }