package com.severstal;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import com.severstal.pages.PracticeFormPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

public class DemoqaFormTest {
    private static final Faker faker = new Faker();
    private static final TestData testData = new TestData();

    @BeforeEach
    void beforeEach() {
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
    void fillStudentRegistrationForm () {
        new PracticeFormPage()
                .setStudentRegistrationForm(testData)
                .checkStudentRegistrationForm(testData);
    }
}