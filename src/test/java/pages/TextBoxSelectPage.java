package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class TextBoxSelectPage {
    private SelenideElement
            nameCheck = $("#output #name"),
            emailCheck = $("#output #email"),
            currentAdressCheck = $("#output #currentAddress"),
            permanentAdressCheck = $("#output #permanentAddress");


    public TextBoxSelectPage nameCheck(String value) {
        nameCheck.shouldHave(text(value));
        return this;
    }

    public TextBoxSelectPage emailCheck(String value) {
        emailCheck.shouldHave(text(value));
        return this;
    }

    public TextBoxSelectPage currentAdressCheck(String value) {
        currentAdressCheck.shouldHave(text(value));
        return this;
    }

    public TextBoxSelectPage permanentAdressCheck(String value) {
        permanentAdressCheck.shouldHave(text(value));
        return this;
    }

}
