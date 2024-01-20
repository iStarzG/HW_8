package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class SelectPage {

    private SelenideElement
            modalCheck = $(".modal-open"),
            tableName = $(".table");


    public SelectPage modalOpenCheck(Condition... conditions) {
        modalCheck.shouldBe(conditions);
        return this;
    }

    public SelectPage tableCheck(String key, String value) {
        tableName.$(byText(key)).parent()
                .shouldHave(text(value));
        return this;
    }

}


