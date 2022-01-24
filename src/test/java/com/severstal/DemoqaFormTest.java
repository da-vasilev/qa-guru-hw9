package com.severstal;

import com.github.javafaker.Faker;
import com.severstal.pages.PracticeFormPage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class DemoqaFormTest extends TestBase{
    private static final Faker faker = new Faker();
    private static final TestData testData = new TestData();

    @BeforeAll
    static void BeforeAll() {
        testData
                .setFirstName(faker.name().firstName())
                .setLastName(faker.name().lastName())
                .setUserEmail(faker.internet().emailAddress())
                .setUserNumber(faker.phoneNumber().subscriberNumber(10))
                .setCurrentAddress(faker.address().fullAddress())
                .setDateOfBirth(faker);

        open("/automation-practice-form");
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
        closeWebDriver();
    }
}