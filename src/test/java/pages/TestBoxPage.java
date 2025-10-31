package pages;

import com.codeborne.selenide.SelenideElement;
import pages.utils.JsSnippetsUtils;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

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

    JsSnippetsUtils jsSnippetsUtils = new JsSnippetsUtils();

    public TestBoxPage openPage() {
        open("/text-box");

        return this;
    }

    public TestBoxPage removeBanners () {
        jsSnippetsUtils.removeBanners();

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