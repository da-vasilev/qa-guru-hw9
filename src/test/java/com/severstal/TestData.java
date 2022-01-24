package com.severstal;

import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;
import java.util.Locale;

public class TestData {
    private final SimpleDateFormat formatter = new SimpleDateFormat("dd/MMMM/yyyy", new Locale("en"));

    private String
            firstName,
            lastName,
            userEmail,
            userNumber,
            currentAddress
                    ;

    private String[] dateOfBirth;

    public String getFirstName() {
        return firstName;
    }

    public TestData setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public TestData setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public TestData setUserEmail(String userEmail) {
        this.userEmail = userEmail;
        return this;
    }

    public String getUserNumber() {
        return userNumber;
    }

    public TestData setUserNumber(String userNumber) {
        this.userNumber = userNumber;
        return this;
    }

    public String getCurrentAddress() {
        return currentAddress;
    }

    public TestData setCurrentAddress(String currentAddress) {
        this.currentAddress = currentAddress;
        return this;
    }

    public String[] getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Faker faker) {
        this.dateOfBirth = formatter.format(faker.date().birthday()).split("/");
    }
}