/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package TestClasses;

import com.mycompany.st10515704.part1.Login;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author kyrah
 */
public class LoginTest {
    
//Question 4(assertTrue/False)
    @Test
    public void testLoginSuccessful() {
        Login log1 = new Login("kyl_1", "Ch&&sec@ke99!", "+27838968976", "Onkgopotse", "Barekwang");
        assertTrue(log1.loginUser("kyl_1", "Ch&&sec@ke99!"));
    }

    @Test
    public void testLoginFailed() {
        Login log = new Login("kyl_1", "Ch&&sec@ke99!", "+27838968976", "Onkgopotse", "Barekwang");
        assertFalse(log.loginUser("wrongUser", "wrongPass"));
    }

    @Test
    public void testUsernameCorrectlyFormattedTrue() {
        Login log1 = new Login("kyl_1", "Ch&&sec@ke99!", "+27838968976", "Onkgopotse", "Barekwang");
        assertTrue(log1.checkUsername());
    }

    @Test
    public void testUsernameIncorrectlyFormattedFalse() {
        Login log1 = new Login("kyle!!!!!!!", "Ch&&sec@ke99!", "+27838968976", "Onkgopotse", "Barekwang");
        assertFalse(log1.checkUsername());
    }

    @Test
    public void testPasswordMeetsComplexityTrue() {
        Login log1 = new Login("kyl_1", "Ch&&sec@ke99!", "+27838968976", "Onkgopotse", "Barekwang");
        assertTrue(log1.checkPasswordComplexity());
    }

    @Test
    public void testPasswordDoesNotMeetComplexityFalse() {
        Login log1 = new Login("kyl_1", "password", "+27838968976", "Onkgopotse", "Barekwang");
        assertFalse(log1.checkPasswordComplexity());
    }

    @Test
    public void testCellPhoneCorrectlyFormattedTrue() {
        Login log1 = new Login("kyl_1", "Ch&&sec@ke99!", "+27838968976", "Onkgopotse", "Barekwang");
        assertTrue(log1.checkPhoneNumber());
    }

    @Test
    public void testCellPhoneIncorrectlyFormattedFalse() {
        Login log1 = new Login("kyl_1", "Ch&&sec@ke99!", "08966553", "Onkgopotse", "Barekwang");
        assertFalse(log1.checkPhoneNumber());
    }
}


