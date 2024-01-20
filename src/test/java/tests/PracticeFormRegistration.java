package tests;


import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.SelectPage;
import pages.components.TestBase;
import Utils.RandomUtils;

import static com.codeborne.selenide.Condition.hidden;
import static com.codeborne.selenide.Condition.visible;

public class PracticeFormRegistration extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    RandomUtils randomUtils = new RandomUtils();
    SelectPage selectPage = new SelectPage();

    @Test
    void succesfulRegistrationWithAllData() {

        registrationPage.openPage()
                .setFirstName(randomUtils.firstName)
                .setLastName(randomUtils.lastName)
                .setEmail(randomUtils.inputEmail)
                .setGender(randomUtils.inputGender)
                .setPhoneNumber(randomUtils.inputPhone)
                .setDateOfBirth(randomUtils.randomDay, randomUtils.randomMonth, randomUtils.randomYear)
                .setSubjects(randomUtils.inputSubject)
                .setHobbies(randomUtils.inputHobby)
                .uploadPicture(randomUtils.pictureName)
                .setCurrentAddress(randomUtils.inputAddress)
                .setState(randomUtils.inputState)
                .setCity(randomUtils.inputCity)
                .submitButton();
        selectPage.modalOpenCheck(visible)
                .tableCheck("Student Name", randomUtils.firstName)
                .tableCheck("Student Name", randomUtils.lastName)
                .tableCheck("Student Email", randomUtils.inputEmail)
                .tableCheck("Gender", randomUtils.inputGender)
                .tableCheck("Mobile", randomUtils.inputPhone)
                .tableCheck("Date of Birth", randomUtils.randomDay + " " + randomUtils.randomMonth + "," + randomUtils.randomYear)
                .tableCheck("Subjects", randomUtils.inputSubject)
                .tableCheck("Hobbies", randomUtils.inputHobby)
                .tableCheck("Picture", randomUtils.pictureName)
                .tableCheck("Address", randomUtils.inputAddress)
                .tableCheck("State and City", randomUtils.inputState)
                .tableCheck("State and City", randomUtils.inputCity);
    }

    @Test
    void RegistrationWithMinimalInformation() {

        registrationPage.openPage()
                .setFirstName(randomUtils.firstName)
                .setLastName(randomUtils.lastName)
                .setGender(randomUtils.inputGender)
                .setPhoneNumber(randomUtils.inputPhone)
                .setDateOfBirth(randomUtils.randomDay, randomUtils.randomMonth, randomUtils.randomYear)
                .submitButton();
        selectPage.modalOpenCheck(visible)
                .tableCheck("Student Name", randomUtils.firstName + " " + randomUtils.lastName)
                .tableCheck("Gender", randomUtils.inputGender)
                .tableCheck("Mobile", randomUtils.inputPhone)
                .tableCheck("Date of Birth", randomUtils.randomDay + " " + randomUtils.randomMonth + "," + randomUtils.randomYear);



    }


    @Test
    void RegistrationEmptyInformation() {
        registrationPage.openPage()
                .submitButton()
                .colorCheck(randomUtils.findColor, randomUtils.colorName);
        selectPage.modalOpenCheck(hidden);
    }
}