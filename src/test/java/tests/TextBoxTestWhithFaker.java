package tests;

import org.junit.jupiter.api.Test;
import pages.TextBoxRegistrationPage;
import pages.TextBoxSelectPage;
import pages.components.TestBase;
import pages.components.TestRandomData;

public class TextBoxTestWhithFaker extends TestBase {

    TextBoxRegistrationPage textBoxPage = new TextBoxRegistrationPage();
    TextBoxSelectPage textBoxSelect = new TextBoxSelectPage();
    TestRandomData testRandomData = new TestRandomData();

    @Test
    void textBoxWithPages() {
        textBoxPage.openPage()
                .setFirstName(testRandomData.firstName)
                .setEmailName(testRandomData.inputEmail)
                .setCurrentAdress(testRandomData.inputAddress)
                .setPermanentAdress(testRandomData.inputAddress2)
                .submitClick();
        textBoxSelect.nameCheck(testRandomData.firstName)
                .emailCheck(testRandomData.inputEmail)
                .currentAdressCheck(testRandomData.inputAddress)
                .permanentAdressCheck(testRandomData.inputAddress2);

    }
}
