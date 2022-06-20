package com.krolka.banksystem.domain;

import java.math.BigDecimal;

public class AccountCreateDto {

    //Account
    private boolean isActive;
    private BigDecimal balance;
    private String companyName;
    private int taxId;
    private String firstName;
    private String lastName;

    public boolean isActive() {
        return isActive;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public String getCompanyName() {
        return companyName;
    }

    public int getTaxId() {
        return taxId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public AccountCreateDto setActive(boolean active) {
        isActive = active;
        return this;
    }

    public AccountCreateDto setBalance(BigDecimal balance) {
        this.balance = balance;
        return this;

    }

    public AccountCreateDto setCompanyName(String companyName) {
        this.companyName = companyName;
        return this;
    }

    public AccountCreateDto setTaxId(int taxId) {
        this.taxId = taxId;
        return this;
    }

    public AccountCreateDto setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public AccountCreateDto setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }
}
