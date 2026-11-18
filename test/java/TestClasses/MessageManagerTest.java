/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package TestClasses;
import com.mycompany.st10515704.part1.Message;
import com.mycompany.st10515704.part1.MessageManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author kyrah
 */
public class MessageManagerTest {
    
         private MessageManager manager;

    @BeforeEach
    public void setUp() {

        manager = new MessageManager();

        // Load Question 3 test data
        manager.loadTestData();
    }

    // ============================
    // QUESTION 3 TEST DATA TESTS
    // ============================

    @Test
    public void testSentMessagesPopulatedCorrectly() {

        assertEquals(2,
                manager.getSentMessages().size());

        assertEquals(
                "Did you get the cake?",
                manager.getSentMessages()
                       .get(0)
                       .getMessageText());

        assertEquals(
                "It is dinner time!",
                manager.getSentMessages()
                       .get(1)
                       .getMessageText());
    }

    @Test
    public void testStoredMessagesPopulatedCorrectly() {

        assertEquals(
                2,
                manager.getStoredMessages().size());

        assertEquals(
                "Where are you? You are late! I have asked you to be on time.",
                manager.getStoredMessages()
                       .get(0)
                       .getMessageText());

        assertEquals(
                "Ok, I am leaving without you.",
                manager.getStoredMessages()
                       .get(1)
                       .getMessageText());
    }

    @Test
    public void testDisregardedMessagesPopulatedCorrectly() {

        assertEquals(
                1,
                manager.getDisregardedMessages().size());

        assertEquals(
                "Yohoooo, I am at your gate.",
                manager.getDisregardedMessages()
                       .get(0)
                       .getMessageText());
    }

    @Test
    public void testMessageIDsCreated() {

        assertEquals(
                5,
                manager.getMessageIDs().size());
    }

    @Test
    public void testMessageHashesCreated() {

        assertEquals(
                5,
                manager.getMessageHashes().size());
    }

    // ============================
    // QUESTION 4 TESTS
    // ============================

    @Test
    public void testLongestStoredMessage() {

        String expected =
                "Where are you? You are late! I have asked you to be on time.";

        assertEquals(
                expected,
                manager.displayLongestStoredMessage());
    }

    @Test
    public void testSearchByMessageID() {

        Message found =
                manager.searchByMessageID("1000000004");

        assertNotNull(found);

        assertEquals(
                "It is dinner time!",
                found.getMessageText());
    }

    @Test
    public void testSearchByRecipient() {

        assertEquals(
                2,
                manager.searchByRecipient("+27838884567")
                       .size());
    }

    @Test
    public void testSearchByRecipientMessages() {

        assertEquals(
                "Where are you? You are late! I have asked you to be on time.",
                manager.searchByRecipient("+27838884567")
                       .get(0)
                       .getMessageText());

        assertEquals(
                "Ok, I am leaving without you.",
                manager.searchByRecipient("+27838884567")
                       .get(1)
                       .getMessageText());
    }

    @Test
    public void testDeleteMessageByHash() {

        int beforeDelete =
                manager.getStoredMessages().size();

        boolean deleted =
                manager.deleteMessageByHash("00:00:WHETIME");

        int afterDelete =
                manager.getStoredMessages().size();

        assertTrue(deleted);

        assertEquals(
                beforeDelete - 1,
                afterDelete);
    }

    @Test
    public void testGenerateReport() {

        String report;
        report = manager.generateReport();

        assertTrue(
                report.contains("Did you get the cake?"));

        assertTrue(
                report.contains("It is dinner time!"));

        assertTrue(
                report.contains("+27834557896"));

        assertTrue(
                report.contains("0838884567"));

        assertTrue(
                report.contains("1000000001"));

        assertTrue(
                report.contains("1000000004"));

        assertTrue(
                report.contains("00:00:DICAKE"));

        assertTrue(
                report.contains("00:00:ITTIME"));
    }
}
    
    

