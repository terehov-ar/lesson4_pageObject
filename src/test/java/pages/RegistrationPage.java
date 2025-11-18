package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.ResultTableComponent;
import pages.utils.JsSnippetsUtils;
import io.qameta.allure.Step;

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
    JsSnippetsUtils jsSnippetsUtils = new JsSnippetsUtils();

    @Step("Открываем страницу с формой регистрации")
    public RegistrationPage openPage() {
        open("/automation-practice-form");

        return this;
    }

    @Step("Убираем баннеры на странице")
    public RegistrationPage removeBanners () {
        jsSnippetsUtils.removeBanners();

        return this;
    }

    @Step("Заполняем имя")
    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    @Step("Заполняем фамилию")
    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    @Step("Заполняем почту")
    public RegistrationPage setEmail(String value) {
        userEmailInput.setValue(value);

        return this;
    }

    @Step("Указываем пол")
    public RegistrationPage setGender(String value) {
        genderWrapper.$(byText(value)).click();

        return this;
    }

    @Step("Заполняем телефон")
    public RegistrationPage setUserNumber(String value) {
        userNumberInput.setValue(value);

        return this;
    }

    @Step("Заполняем дату рождения")
    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        calendarInput.click();
        calendarComponent.setDate(day, month, year);

        return this;
    }

    @Step("Указываем учебный предмет")
    public RegistrationPage setSubject(String value) {
        subjectsInput.setValue(value).pressEnter();

        return this;
    }

    @Step("Заполняем текущий адрес проживания")
    public RegistrationPage setCurrentAddress (String value) {
        currentAddressInput.setValue(value);

        return this;
    }

    @Step("Заполняем хобби")
    public RegistrationPage setHobbies (String value) {
        hobbiesInput.$(byText(value)).click();

        return this;
    }

    @Step("Заполняем штат")
    public RegistrationPage setState (String value) {
        stateInput.click();
        stateInput.$(byText(value)).click();

        return this;
    }

    @Step("Заполняем город")
    public RegistrationPage setCity (String value) {
        cityInput.click();
        cityInput.$(byText(value)).click();

        return this;
    }

    @Step("Загружаем вложения")
    public RegistrationPage uploadAttachment (String attachment) {
        uploadAttach.uploadFromClasspath(attachment);

        return this;
    }

    @Step("Нажимаем кнопку Submit")
    public RegistrationPage pressSubmit () {
        submitButton.scrollTo().click();

        return this;
    }

    @Step("Проверяем результат заполнения таблицы")
    public RegistrationPage checkResult(String key, String value) {
        resultTable.checkResult(key, value);

        return this;
    }

    @Step("Проверяем наличие модального окна")
    public RegistrationPage checkFinishModalName () {
        finishModal.shouldHave(text("Thanks for submitting the form"));

        return this;
    }

    @Step("Проверяем отсутствие заполнения")
    public RegistrationPage checkAttributeIsNull (String value) {
        resultTable.checkNullResult(value);

        return this;
    }

    @Step("Проверяем шаблон заполнения почты")
    public RegistrationPage checkPatternEmail () {
        userEmailInput.shouldHave(attribute("pattern", "^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$"));

        return this;
    }

    @Step("Проверяем результат заполнения таблицы")
    public RegistrationPage availabilityCheckFinishModal () {
        finishModal.shouldNot(exist);

        return this;
    }

    @Step("Проверяем min max длину номера телефона")
    public RegistrationPage checkMinMaxUserNumber() {
        userNumberInput.shouldHave(attribute("minlength", "10"));
        userNumberInput.shouldHave(attribute("maxlength", "10"));

        return this;
    }
}