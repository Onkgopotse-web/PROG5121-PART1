/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package TestClasses;

import com.mycompany.st10515704.part1.Message;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author kyrah
 */
public class MessageTest1 {
    

    // -------------------------
    // Task 1: SendMessage Tests
    // -------------------------
    @Test
    public void testSendMessage_ValidRecipient_ShouldReturnTrue() {
        Message msg1 = new Message();
        boolean result = msg1.sendMessage(1, "+27718693002",
                "Hi Mike, can you join us for dinner tonight?", 1);
        assertTrue(result, "Message should be sent successfully...");
    }

    @Test
    public void testSendMessage_InvalidRecipient_ShouldReturnFalse() {
        Message msg1 = new Message();
        boolean result = msg1.sendMessage(2, "08575975889",
                "Hi Keegan, did you receive the payment?", 2);
        assertFalse(result, "Message should not be sent...");
    }

    @Test
    public void testSendMessage_MessageTooLong_ShouldReturnFalse() {
        Message msg1 = new Message();
        String longMessage = "A".repeat(300);
        boolean result = msg1.sendMessage(3, "+27712345678", longMessage, 1);
        assertFalse(result, "Message should fail...");
    }

    // -------------------------
    // Task 2: Validation Tests
    // -------------------------
    @Test
    public void testCheckMessageID_ShouldBeTenDigits() {
        Message msg1 = new Message();
        String id = "1234567890";
        assertTrue(msg1.checkMessageID(id), "Message ID should be valid...");
    }

    @Test
    public void testCheckRecipientCell_ShouldValidateCorrectly() {
        Message msg1 = new Message();
        String validRecipient = "+2787654321";
        String invalidRecipient = "123456";

        assertEquals("Cell phone number successfully captured.",
                msg1.checkRecipientCell(validRecipient));
        assertEquals("Cell phone number is incorrectly formatted or does not contain an international code. Please correct the number and try again.",
                msg1.checkRecipientCell(invalidRecipient));
    }

    @Test
    public void testReturnTotalMessages_ShouldReturnCorrectCount() {
        Message msg1 = new Message();
        int totalSent = 2;
        assertEquals(2, msg1.returnTotalMessages(totalSent),
                "Total messages should match...");
    }

    // -------------------------
    // Task 3: AssertEquals Tests
    // -------------------------
    @Test
    public void testMessageLength_Valid_ShouldReturnSuccessMessage() {
        Message msg1 = new Message();
        String shortMessage = "Dinner tonight at 7pm.";
        String result = msg1.checkMessageLength(shortMessage);
        assertEquals("Message ready to send.", result,
                "Expected success when message length is under 250 characters.");
    }

    @Test
    public void testMessageLength_TooLong_ShouldReturnFailureMessage() {
        Message msg = new Message();
        String longMessage = "A".repeat(300);
        String result = msg.checkMessageLength(longMessage);
        assertEquals("Message exceeds 250 characters by 50; please reduce the size.", result,
                "Expected failure when message length exceeds 250 characters.");
    }

    @Test
    public void testRecipientNumber_Valid_ShouldReturnSuccessMessage() {
        Message msg = new Message();
        String validRecipient = "+2787654321";
        String result = msg.checkRecipientCell(validRecipient);
        assertEquals("Cell phone number successfully captured.", result,
                "Expected success when recipient number is correctly formatted.");
    }

    @Test
    public void testRecipientNumber_Invalid_ShouldReturnFailureMessage() {
        Message msg = new Message();
        String invalidRecipient = "123456";
        String result = msg.checkRecipientCell(invalidRecipient);
        assertEquals("Cell phone number is incorrectly formatted or does not contain an international code. Please correct the number and try again.",
                result, "Expected failure when recipient number is incorrectly formatted.");
    }

    @Test
    public void testMessageHash_ShouldReturnCorrectHash() {
        Message msg1 = new Message();
        String message = "Hi Mike, can you join us for dinner tonight?";
        String hash = msg1.generateMessageHash(message);
        assertEquals("00:0:HITONIGHT", hash,
                "Expected hash output for Test Case 1 message.");
    }

    @Test
    public void testMessageID_ShouldBeGenerated() {
        Message msg = new Message();
        String id = msg.generateMessageID();
        assertTrue(id.matches("\\d{10}"),
                "Expected Message ID to be generated as a 10-digit number.");
    }

    @Test
    public void testSendMessage_ShouldReturnSuccessMessage() {
        Message msg = new Message();
        String result = msg.processMessageOption(1);
        assertEquals("Message successfully sent.", result,
                "Expected system output when user selects Send Message.");
    }

    @Test
    public void testDisregardMessage_ShouldReturnDeletePrompt() {
        Message msg = new Message();
        String result = msg.processMessageOption(2);
        assertEquals("Press 0 to delete the message.", result,
                "Expected system output when user selects Disregard Message.");
    }

    @Test
    public void testStoreMessage_ShouldReturnStoredMessage() {
        Message msg = new Message();
        String result = msg.processMessageOption(3);
        assertEquals("Message successfully stored.", result,
                "Expected system output when user selects Store Message.");
    }
}

        
    
    

