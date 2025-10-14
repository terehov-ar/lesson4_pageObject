package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class TestBoxPage {
    private SelenideElement firstNameInput = $("#firstName"),
            userNameInput = $("#userName"),
            userEmailInput = $("#userEmail"),
            currentAddressInput = $("#currentAddress"),
            permanentAddressInput = $("#permanentAddress"),
            submitButton = $("#submit"),
            resultName =  $("#output #name"),
            resultEmail = $("#output #email"),
            resultCurrentAddress = $("#output #currentAddress"),
            resultPermanentAddress = $("#output #permanentAddress");


    public TestBoxPage openPage() {
        open("/text-box");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }

    public TestBoxPage setUserName (String value) {
        userNameInput.setValue(value);

        return this;
    }

    public TestBoxPage setUserEmail (String value) {
        userEmailInput.setValue(value);

        return this;
    }

    public TestBoxPage setCurrentAddress (String value) {
        currentAddressInput.setValue(value);

        return this;
    }

    public TestBoxPage setPermanentAddress (String value) {
        permanentAddressInput.setValue(value);

        return this;
    }
    public TestBoxPage pressSubmit() {
        submitButton.click();

        return this;
    }

    public TestBoxPage checkUserName (String value) {
        resultName.shouldHave(text(value));

        return this;
    }

    public TestBoxPage checkUserEmail (String value) {
        resultEmail.shouldHave(text(value));

        return this;
    }

    public TestBoxPage checkCurrentAddress (String value) {
        resultCurrentAddress.shouldHave(text(value));

        return this;
    }

    public TestBoxPage checkPermanentAddress (String value) {
        resultPermanentAddress.shouldHave(text(value));

        return this;
    }
}