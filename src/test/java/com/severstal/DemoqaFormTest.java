package com.severstal;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import com.severstal.helpers.Attachments;
import com.severstal.pages.PracticeFormPage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class DemoqaFormTest {
    private static final Faker faker = new Faker();
    private static final TestData testData = new TestData();

    @BeforeAll
    static void BeforeAll() {
        Configuration.browserSize = "1920x1280";
        open("https://demoqa.com/automation-practice-form");

        testData
                .setFirstName(faker.name().firstName())
                .setLastName(faker.name().lastName())
                .setUserEmail(faker.internet().emailAddress())
                .setUserNumber(faker.phoneNumber().subscriberNumber(10))
                .setCurrentAddress(faker.address().fullAddress())
                .setDateOfBirth(faker);
    }

    @Test
    @DisplayName("Тестирование формы PracticeForm")
    void fillFormTest () {
        new PracticeFormPage()
                .fillStudentRegistrationForm(testData)
                .checkStudentRegistrationForm(testData);
    }

    @AfterAll
    static void AfterAll() {
        Attachments.screenshotAs("Last screenshot");
        Attachments.pageSource();
        Attachments.browserConsoleLogs();
        Attachments.addVideo();
        closeWebDriver();
    }
}