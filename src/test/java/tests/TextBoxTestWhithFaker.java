package tests;


import Utils.RandomUtils;
import org.junit.jupiter.api.Test;
import pages.TextBoxRegistrationPage;
import pages.TextBoxSelectPage;
import pages.components.TestBase;

public class TextBoxTestWhithFaker extends TestBase {

    TextBoxRegistrationPage textBoxPage = new TextBoxRegistrationPage();
    TextBoxSelectPage textBoxSelect = new TextBoxSelectPage();
    RandomUtils randomUtils = new RandomUtils();
    @Test
    void textBoxWithPages () {
        textBoxPage.openPage()
                .setFirstName(randomUtils.firstName)
                .setEmailName(randomUtils.inputEmail)
                .setCurrentAdress(randomUtils.inputAddress)
                .setPermanentAdress(randomUtils.inputAddress2)
                .submitClick();
        textBoxSelect.nameCheck(randomUtils.firstName)
                .emailCheck(randomUtils.inputEmail)
                .currentAdressCheck(randomUtils.inputAddress)
                .permanentAdressCheck(randomUtils.inputAddress2);

    }
}
