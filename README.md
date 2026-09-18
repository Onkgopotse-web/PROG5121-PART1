# # PROG5121‑PART1

## Project Overview
This repository contains the source code and JUnit tests for **Question 4** of the PROG5121 POE.  
The project demonstrates how to validate user registration and login details using Java and JUnit in NetBeans.

---

## Features
- **Main.java**
  - Entry point of the program.
  - Demonstrates how Registration and Login classes work together.
  - Accepts user input, runs validations, and displays results.
  - Shows login success or failure based on credentials.

- **Registration.java**
  - Validates username, password, and cell phone number.
  - Returns clear messages for correctly and incorrectly formatted inputs.
  - Displays a personalized welcome message when the username is valid.

- **Login.java**
  - Verifies login credentials using Boolean checks.
  - Confirms whether username, password, and cell number meet formatting rules.
  - Returns `true` or `false` for login success or failure.

- **JUnit Tests**
  - `RegistrationTest.java` uses `assertEquals()` to compare expected and actual messages.
  - `LoginTest.java` uses `assertTrue()` and `assertFalse()` to verify Boolean results.
  - Test data matches the POE Question 4 table exactly.

---

## Test Data Summary
| Test Case | Input | Expected Output |
|------------|--------|----------------|
| Username correctly formatted | `kyl_1` | `Welcome Onkgopotse, Barekwang it is great to see you.` |
| Username incorrectly formatted | `kyle!!!!!!!` | `Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.` |
| Password meets complexity | `Ch&&sec@ke99!` | `Password successfully captured.` |
| Password fails complexity | `password` | `Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.` |
| Cell number correctly formatted | `+27838968976` | `Cell number successfully captured.` |
| Cell number incorrectly formatted | `08966553` | `Cell number is incorrectly formatted or does not contain an international code; please correct the number and try again.` |

---

## How to Run Tests
1. Open the project in **Apache NetBeans IDE 30**.  
2. Right‑click each test class (`RegistrationTest.java` and `LoginTest.java`).  
3. Select **Run File** to execute the tests.  
4. A **green bar** indicates all tests passed successfully.

---

## User Desktop Screenshot Image
The following screenshot shows the workspace setup used while completing Question 4.  
Use this image as a **map** to understand:
- Where the apps are placed on the screen (Edge on the left, NetBeans on the right).  
- Operating system components not visible in app screenshots (taskbar, window layout).  
- How the environment looked while coding and testing.

![User Desktop Screenshot](screenshot.png)

---

## Author
**Onkgopotse Barekwang**  
Student at **IIE Rosebank College**  
Module: **PROG5121 – Programming

---

## Notes
- All test data and expected outputs follow the official POE Question 4 marking guide.  
- The project demonstrates proper use of constructors, conditional logic, and JUnit testing best practices.
official POE marking guide.  
- Demonstrates understanding of constructors, conditional logic, and automated testing.

## REFRENCES 
