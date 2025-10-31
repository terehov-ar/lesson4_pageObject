package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ResultTableComponent {

    private final SelenideElement tableResponse = $(".table-responsive");

    public void checkResult(String key, String value) {
        tableResponse.$(byText(key)).parent().shouldHave(text(value));
    }

    public void checkNullResult(String key) {
        tableResponse.$(byText(key)).parent().lastChild().shouldHave(exactText(""));
    }
}