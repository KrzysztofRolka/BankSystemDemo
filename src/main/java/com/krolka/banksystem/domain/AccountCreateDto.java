package com.krolka.banksystem.domain;

import java.math.BigDecimal;


//BUILDER PATTERN
public class AccountCreateDto {

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

    private AccountCreateDto() {

    }

    //Static Factory Method
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private boolean isActive;
        private BigDecimal balance;
        private String companyName;
        private int taxId;
        private String firstName;
        private String lastName;


        public Builder isActive(boolean isActive) {
            this.isActive = isActive;
            return this;
        }

        public Builder balance(BigDecimal balance) {
            this.balance = balance;
            return this;
        }

        public Builder companyName(String companyName) {
            this.companyName = companyName;
            return this;
        }

        public Builder taxId(int taxId) {
            this.taxId = taxId;
            return this;
        }

        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public AccountCreateDto bulid() {
            AccountCreateDto dto = new AccountCreateDto();
            dto.isActive = this.isActive;
            dto.balance = this.balance;
            dto.taxId = this.taxId;
            dto.companyName = this.companyName;
            dto.firstName = this.firstName;
            dto.lastName = this.lastName;
            return dto;
        }
    }
}