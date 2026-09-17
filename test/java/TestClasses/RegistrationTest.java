/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package TestClasses;

import com.mycompany.st10515704.part1.Registration;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author kyrah
 */
public class RegistrationTest {
    
   @Test 
   public void testUsernameCorrectFormat(){
       Registration reg1 = new Registration("kyl_1","Ch&&sec@ke99!","+27838968976","Onkgopotse", "Barekwang");
       String expected = "Welcome Onkgopotse,Barekwang it is great to see you!";
       assertEquals(expected,reg1.checkUsername());
   }
    @Test 
   public void testUsernameIncorrectFormat(){
       Registration reg1 = new Registration("kyle!!!!!!!","Ch&&sec@ke99!","+27838968976","Onkgopotse", "Barekwang");
       String expected = "Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.";
       assertEquals(expected,reg1.checkUsername());
   }
   @Test 
   public void testPasswordMeetsComplexityRequirements(){
       Registration reg1 = new Registration("kyl_1","Ch&&sec@ke99!","+27838968976","Onkgopotse", "Barekwang");
       String expected = "Password successfully captured.";
       assertEquals(expected,reg1.checkPassword());
   }
   @Test 
   public void testPasswordDoesNotMeetComplexityRequirements(){
       Registration reg1 = new Registration("kyl_1","password","+27838968976","Onkgopotse", "Barekwang");
       String expected = "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";
       assertEquals(expected,reg1.checkPassword());
   }
   @Test 
   public void testPhoneNumberCorrectFormat(){
       Registration reg1 = new Registration("kyl_1","Ch&&sec@ke99!","+27838968976","Onkgopotse", "Barekwang");
       String expected = "Cell phone number successfully added.";
       assertEquals(expected,reg1.checkCellPhoneNumber());
   }
   @Test 
   public void testPhoneNumberIncorrectFormat(){
       Registration reg1 = new Registration("kyl_1","Ch&&sec@ke99!","08966553","Onkgopotse", "Barekwang");
       String expected = "Cell phone number incorrectly formatted or does not contain an international code; please correct the number and try again.";
       assertEquals(expected,reg1.checkCellPhoneNumber());
   }
}
