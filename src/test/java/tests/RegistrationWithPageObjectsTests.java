package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

public class RegistrationWithPageObjectsTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void successFullRegistrationTest() {
        registrationPage.openPage()
                .setFirstName("Vitaliy")
                .setLastName("Arthas")
                .setEmail("vitaliyarthasovich@mail.ru")
                .setGender("Male")
                .setUserNumber("8999999999")
                .setDateOfBirth("17", "October", "1984")
                .setSubject("Maths")
                .setHobbies("Reading")
                .uploadAttachment("Locators_table.pdf")
                .setCurrentAddress("Манежная пл., 1, строение 2, Москва, 125009")
                .setState("NCR")
                .setCity("Noida")
                .pressSubmit()
                .checkFinishModalName()
                .checkResult("Student Name", "Vitaliy Arthas")
                .checkResult("Student Email", "vitaliyarthasovich@mail.ru")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "8999999999")
                .checkResult("Date of Birth", "17 October,1984")
                .checkResult("Subjects", "Maths")
                .checkResult("Hobbies", "Reading")
                .checkResult("Picture", "Locators_table.pdf")
                .checkResult("Address", "Манежная пл., 1, строение 2, Москва, 125009")
                .checkResult("State and City", "NCR Noida");
    }
    @Test
    void successMinRegistrationTest() {
        registrationPage.openPage()
                .setFirstName("Vitaliy")
                .setLastName("Arthas")
                .setGender("Male")
                .setUserNumber("8999999999")
                .pressSubmit()
                .checkFinishModalName()
                .checkResult("Student Name", "Vitaliy Arthas")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "8999999999")
                .checkAttributeIsNull("Student Email")
                .checkAttributeIsNull("Hobbies")
                .checkAttributeIsNull("Picture")
                .checkAttributeIsNull("Address")
                .checkAttributeIsNull("State and City");

    }

    @Test
    void negativeEmailCheckTest() {
        registrationPage.openPage()
                .setFirstName("Vitaliy")
                .setLastName("Arthas")
                .setGender("Male")
                .setUserNumber("8999999999")
                .checkPatternEmail()
                .setEmail("testemailfrovalidation/gmail.com")
                .pressSubmit()
                .availabilityCheckFinishModal();
    }

    @Test
    void negativePhoneCheckTest() {
        registrationPage.openPage()
                .setFirstName("Vitaliy")
                .setLastName("Arthas")
                .setGender("Male")
                .checkMinMaxUserNumber()
                .setUserNumber("899999999")
                .pressSubmit()
                .availabilityCheckFinishModal()
                .setUserNumber("8999999912345")
                .pressSubmit()
                .checkFinishModalName();
    }

}