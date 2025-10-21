package pages.components;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ResultTableComponent {

    public void checkResult(String key, String value) {
        $(".table-responsive").$(byText(key)).parent().shouldHave(text(value));
    }

    public void checkNullResult(String key) {
        $(".table-responsive").$(byText(key)).parent().lastChild().shouldHave(exactText(""));
    }
}