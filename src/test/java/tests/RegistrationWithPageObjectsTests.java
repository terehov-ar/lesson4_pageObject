package tests;

import data.TestData;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

public class RegistrationWithPageObjectsTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    TestData testData = new TestData();

    @Test
    @Tag("WEB_positiveCase")
    void successFullRegistrationTest() {

        registrationPage.openPage()
                .removeBanners()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setEmail(testData.email)
                .setGender(testData.gender)
                .setUserNumber(testData.number)
                .setDateOfBirth(testData.day, testData.month, testData.year)
                .setSubject(testData.subject)
                .setHobbies(testData.hobbies)
                .uploadAttachment(testData.attachment)
                .setCurrentAddress(testData.address)
                .setState(testData.state)
                .setCity(testData.city)
                .pressSubmit()
                .checkFinishModalName()
                .checkResult("Student Name", testData.firstName + " " + testData.lastName)
                .checkResult("Student Email", testData.email)
                .checkResult("Gender", testData.gender)
                .checkResult("Mobile", testData.number)
                .checkResult("Date of Birth", testData.day + " " + testData.month + "," +testData.year)
                .checkResult("Subjects", testData.subject)
                .checkResult("Hobbies", testData.hobbies)
                .checkResult("Picture", testData.attachment)
                .checkResult("Address", testData.address)
                .checkResult("State and City", testData.state + " " + testData.city);
    }

    @Test
    @Tag("WEB_positiveCase")
    void successMinRegistrationTest() {
        registrationPage.openPage()
                .removeBanners()
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
    @Tag("WEB_negativeCase")
    void negativeEmailCheckTest() {
        registrationPage.openPage()
                .removeBanners()
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
    @Tag("WEB_negativeCase")
    void negativePhoneCheckTest() {
        registrationPage.openPage()
                .removeBanners()
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