package com.krolka.banksystem.domain;

import java.math.BigDecimal;
import java.util.List;

public abstract class Account {

    private boolean isActive;
    private BigDecimal balance;

    private List<Transaction> transactions;
    public Account() {
    }

    public Account(boolean isActive, BigDecimal balance) {
        this.isActive = isActive;
        this.balance = balance;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
