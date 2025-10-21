package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.ResultTableComponent;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
    private final SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderWrapper = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            calendarInput = $("#dateOfBirthInput"),
            subjectsInput = $("#subjectsInput"),
            hobbiesInput = $("#hobbiesWrapper"),
            currentAddressInput = $("#currentAddress"),
            stateInput = $("#state"),
            cityInput = $("#city"),
            submitButton = $("#submit"),
            uploadAttach = $("#uploadPicture"),
            finishModal = $("#example-modal-sizes-title-lg");

    CalendarComponent calendarComponent = new CalendarComponent();
    ResultTableComponent resultTable = new ResultTableComponent();

    public RegistrationPage openPage() {
        open("/automation-practice-form");

        return this;
    }

    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setEmail(String value) {
        userEmailInput.setValue(value);

        return this;
    }

    public RegistrationPage setGender(String value) {
        genderWrapper.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setUserNumber(String value) {
        userNumberInput.setValue(value);

        return this;
    }

    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        calendarInput.click();
        calendarComponent.setDate(day, month, year);

        return this;
    }

    public RegistrationPage setSubject(String value) {
        subjectsInput.setValue(value).pressEnter();

        return this;
    }

    public RegistrationPage setCurrentAddress (String value) {
        currentAddressInput.setValue(value);

        return this;
    }

    public RegistrationPage setHobbies (String value) {
        hobbiesInput.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setState (String value) {
        stateInput.click();
        stateInput.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setCity (String value) {
        cityInput.click();
        cityInput.$(byText(value)).click();

        return this;
    }

    public RegistrationPage uploadAttachment (String attachment) {
        uploadAttach.uploadFromClasspath(attachment);

        return this;
    }

    public RegistrationPage pressSubmit () {
        submitButton.click();

        return this;
    }

    public RegistrationPage checkResult(String key, String value) {
        resultTable.checkResult(key, value);

        return this;
    }

    public RegistrationPage checkFinishModalName () {
        finishModal.shouldHave(text("Thanks for submitting the form"));

        return this;
    }

    public RegistrationPage checkAttributeIsNull (String value) {
        resultTable.checkNullResult(value);

        return this;
    }

    public RegistrationPage checkPatternEmail () {
        userEmailInput.shouldHave(attribute("pattern", "^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$"));

        return this;
    }

    public RegistrationPage availabilityCheckFinishModal () {
        finishModal.shouldNot(exist);

        return this;
    }

    public RegistrationPage checkMinMaxUserNumber() {
        userNumberInput.shouldHave(attribute("minlength", "10"));
        userNumberInput.shouldHave(attribute("maxlength", "10"));

        return this;
    }
}