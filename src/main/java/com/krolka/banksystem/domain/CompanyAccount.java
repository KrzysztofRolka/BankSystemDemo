package com.krolka.banksystem.domain;

import java.math.BigDecimal;

public class CompanyAccount extends Account {

    private String companyName;
    private int taxId;

    public CompanyAccount() {
    }

    public CompanyAccount(String companyName, int taxId, boolean isActive, BigDecimal balance) {
        super(isActive, balance);
        this.companyName = companyName;
        this.taxId = taxId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public int getTaxId() {
        return taxId;
    }

    public void setTaxId(int taxId) {
        this.taxId = taxId;
    }
}
