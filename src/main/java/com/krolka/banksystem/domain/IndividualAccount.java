package com.krolka.banksystem.domain;

import java.math.BigDecimal;

public class IndividualAccount extends Account{

    private String firstName;
    private String lastName;

    public IndividualAccount() {
    }

    public IndividualAccount(String firstName, String lastName,boolean isActive, BigDecimal balance) {
        super(isActive, balance);
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
