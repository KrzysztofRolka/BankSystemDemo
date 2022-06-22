package com.krolka.banksystem.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public abstract class Account {

    private boolean isActive;
    private BigDecimal balance;

    private List<Transaction> transactions ;
    public Account() {
    }

    public Account(boolean isActive, BigDecimal balance) {
        this.isActive = isActive;
        this.balance = balance;
        this.transactions = new ArrayList<>();
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

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public String sign(){
        return null;
    }
}
