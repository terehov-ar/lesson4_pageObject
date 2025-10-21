package tests;

import data.TestData;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

public class RegistrationWithPageObjectsTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    TestData testData = new TestData();

    @Test
    void successFullRegistrationTest() {
        registrationPage.openPage()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setEmail(testData.email)
                .setGender(testData.gender)
                .setUserNumber(testData.number)
                .setDateOfBirth("17", "October", "1984")
                .setSubject(testData.subject)
                .setHobbies(testData.hobbies)
                .uploadAttachment("Locators_table.pdf")
                .setCurrentAddress(testData.address)
                .setState(testData.state)
                .setCity(testData.city)
                .pressSubmit()
                .checkFinishModalName()
                .checkResult("Student Name", testData.firstName + " " + testData.lastName)
                .checkResult("Student Email", testData.email)
                .checkResult("Gender", testData.gender)
                .checkResult("Mobile", testData.number)
                .checkResult("Date of Birth", "17 October,1984")
                .checkResult("Subjects", testData.subject)
                .checkResult("Hobbies", testData.hobbies)
                .checkResult("Picture", "Locators_table.pdf")
                .checkResult("Address", testData.address)
                .checkResult("State and City", testData.state + " " + testData.city);
    }
    @Test
    void successMinRegistrationTest() {
        registrationPage.openPage()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setGender(testData.gender)
                .setUserNumber(testData.number)
                .pressSubmit()
                .checkFinishModalName()
                .checkResult("Student Name", testData.firstName + " " + testData.lastName)
                .checkResult("Gender", testData.gender)
                .checkResult("Mobile", testData.number)
                .checkAttributeIsNull("Student Email")
                .checkAttributeIsNull("Hobbies")
                .checkAttributeIsNull("Picture")
                .checkAttributeIsNull("Address")
                .checkAttributeIsNull("State and City");

    }

    @Test
    void negativeEmailCheckTest() {
        registrationPage.openPage()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setGender(testData.gender)
                .setUserNumber(testData.number)
                .checkPatternEmail()
                .setEmail(testData.address)
                .pressSubmit()
                .availabilityCheckFinishModal();
    }

    @Test
    void negativePhoneCheckTest() {
        registrationPage.openPage()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setGender(testData.gender)
                .checkMinMaxUserNumber()
                .setUserNumber(testData.notValidMinNumber)
                .pressSubmit()
                .availabilityCheckFinishModal()
                .setUserNumber(testData.notValidMaxNumber)
                .pressSubmit()
                .checkFinishModalName();
    }
}