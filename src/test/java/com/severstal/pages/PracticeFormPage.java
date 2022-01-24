package com.severstal.pages;

import com.severstal.TestData;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

/**
 * <b>Page Practice Form web site Demoqa</b>
 * @author da.vasilev
 */
public class PracticeFormPage {

    /**
     *  <b>Fills out the form on the page</b>
     * @return this
     */
    public PracticeFormPage setStudentRegistrationForm(TestData testData) {
        $("#firstName").setValue(testData.getFirstName());
        $("#lastName").setValue(testData.getLastName());
        $("#userEmail").setValue(testData.getUserEmail());
        $(byText("Male")).click();
        $("#userNumber").setValue(testData.getUserNumber());
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(testData.getDateOfBirth()[1]);
        $(".react-datepicker__year-select").selectOption(testData.getDateOfBirth()[2]);
        $(String.format(".react-datepicker__day--0%s", testData.getDateOfBirth()[0])).click();
        $("#subjectsInput").setValue("English").pressEnter();
        $x("//label[contains(., 'Sports')]").click();
        $("#uploadPicture").uploadFromClasspath("starPhoto.jpg");
        $("#currentAddress").setValue(testData.getCurrentAddress());
        $("#state #react-select-3-input").setValue("NCR").pressEnter();
        $("#city #react-select-4-input").setValue("Delhi").pressEnter();
        $("#submit").scrollTo();
        $("#submit").click();
        return this;
    }

    /**
     *  <b>Validates the form on the page</b>
     * @return this
     */
    public PracticeFormPage checkStudentRegistrationForm(TestData testData) {
        $(".table").shouldHave(
                text("Thanks for submitting the form"),
                text(String.format("%s %s", testData.getFirstName(), testData.getLastName())),
                text(testData.getUserEmail()),
                text("Male"),
                text(testData.getUserNumber()),
                text(String.format("%s %s,%s",
                        testData.getDateOfBirth()[0],
                        testData.getDateOfBirth()[1],
                        testData.getDateOfBirth()[2])),
                text("English"),
                text("Sports"),
                text("starPhoto.jpg"),
                text(testData.getCurrentAddress()),
                text("NCR Delhi")
        );
        return this;
    }
}