package tests;

import org.junit.jupiter.api.Test;
import pages.TestBoxPage;

public class TextBoxTestsWithPageObjectsTests extends TestBase {

    TestBoxPage testBoxPage = new TestBoxPage();

    @Test
    void fillFormTest() {

        testBoxPage.openPage()
                .removeBanners()
                .setUserName("Alex")
                .setUserEmail("alex@egorov.com")
                .setCurrentAddress("Some street 1")
                .setPermanentAddress("Another street 1")
                .pressSubmit()
                .checkUserName("Alex")
                .checkUserEmail("alex@egorov.com")
                .checkCurrentAddress("Some street 1")
                .checkPermanentAddress("Another street 1");

    }
}
