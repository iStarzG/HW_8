package tests;


import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.SelectPage;
import pages.components.TestBase;
import pages.components.TestRandomData;

import static com.codeborne.selenide.Condition.hidden;
import static com.codeborne.selenide.Condition.visible;

public class PracticeFormRegistration extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    TestRandomData testRandomData = new TestRandomData();
    SelectPage selectPage = new SelectPage();

    @Test
    void succesfulRegistrationWithAllData() {

        registrationPage.openPage()
                .setFirstName(testRandomData.firstName)
                .setLastName(testRandomData.lastName)
                .setEmail(testRandomData.inputEmail)
                .setGender(testRandomData.inputGender)
                .setPhoneNumber(testRandomData.inputPhone)
                .setDateOfBirth(testRandomData.dayRandom, testRandomData.randomMonth, testRandomData.randomYear)
                .setSubjects(testRandomData.inputSubject)
                .setHobbies(testRandomData.inputHobby)
                .uploadPicture(testRandomData.pictureName)
                .setCurrentAddress(testRandomData.inputAddress)
                .setState(testRandomData.inputState)
                .setCity(testRandomData.inputCity)
                .submitButton();
        selectPage.modalOpenCheck(visible)
                .tableCheck("Student Name", testRandomData.firstName)
                .tableCheck("Student Name", testRandomData.lastName)
                .tableCheck("Student Email", testRandomData.inputEmail)
                .tableCheck("Gender", testRandomData.inputGender)
                .tableCheck("Mobile", testRandomData.inputPhone)
                .tableCheck("Date of Birth", testRandomData.setRandomDay + " " + testRandomData.randomMonth + "," + testRandomData.randomYear)
                .tableCheck("Subjects", testRandomData.inputSubject)
                .tableCheck("Hobbies", testRandomData.inputHobby)
                .tableCheck("Picture", testRandomData.pictureName)
                .tableCheck("Address", testRandomData.inputAddress)
                .tableCheck("State and City", testRandomData.inputState)
                .tableCheck("State and City", testRandomData.inputCity);
    }

    @Test
    void RegistrationWithMinimalInformation() {

        registrationPage.openPage()
                .setFirstName(testRandomData.firstName)
                .setLastName(testRandomData.lastName)
                .setGender(testRandomData.inputGender)
                .setPhoneNumber(testRandomData.inputPhone)
                .setDateOfBirth(testRandomData.dayRandom, testRandomData.randomMonth, testRandomData.randomYear)
                .submitButton();
        selectPage.modalOpenCheck(visible)
                .tableCheck("Student Name", testRandomData.firstName + " " + testRandomData.lastName)
                .tableCheck("Gender", testRandomData.inputGender)
                .tableCheck("Mobile", testRandomData.inputPhone)
                .tableCheck("Date of Birth", testRandomData.setRandomDay + " " + testRandomData.randomMonth + "," + testRandomData.randomYear);


    }


    @Test
    void RegistrationEmptyInformation() {
        registrationPage.openPage()
                .submitButton()
                .colorCheck(testRandomData.findColor, testRandomData.colorName);
        selectPage.modalOpenCheck(hidden);
    }
}