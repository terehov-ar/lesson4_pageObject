package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.timeout = 5000; // default 4000
    }

    @Test
    void fillPracticeForm () {
        open("/automation-practice-form");
        $("#firstName").setValue("Vitaliy");
        $("#lastName").setValue("Arthas");
        $("#userEmail").setValue("vitaliyarthasovich@mail.ru");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("8999999999");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("October");
        $(".react-datepicker__year-select").selectOption("1984");
        $(".react-datepicker__month").$(byText("17")).click();
        $("#subjectsInput").setValue("Maths").pressEnter();
        $("#hobbiesWrapper").$(byText("Reading")).click();
        $("#currentAddress").setValue("Venèsia");
        $("#state").click();
        $("#react-select-3-option-2").click();
        $("#city").click();
        $("#react-select-4-option-0").click();
        $("#submit").click();
        $("#uploadPicture").uploadFromClasspath("Locators_table.pdf");

        $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text("Vitaliy Arthas"));
        $(".table-responsive").$(byText("Student Email")).parent().shouldHave(text("vitaliyarthasovich@mail.ru"));
        $(".table-responsive").$(byText("Gender")).parent().shouldHave(text("Male"));
        $(".table-responsive").$(byText("Mobile")).parent().shouldHave(text("8999999999"));
        $(".table-responsive").$(byText("Date of Birth")).parent().shouldHave(text("17 October,1984"));
        $(".table-responsive").$(byText("Subjects")).parent().shouldHave(text("Maths"));
        $(".table-responsive").$(byText("Hobbies")).parent().shouldHave(text("Reading"));
        $(".table-responsive").$(byText("Picture")).parent().shouldHave(text("Locators_table.pdf"));
        $(".table-responsive").$(byText("Address")).parent().shouldHave(text("Venèsia"));
        $(".table-responsive").$(byText("State and City")).parent().shouldHave(text("Haryana Karnal"));

    }

}