package pages.utils;

import static com.codeborne.selenide.Selenide.executeJavaScript;

public class JsSnippetsUtils {

    public void removeBanners() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

    }
}
