package com.krolka.banksystem.domain;

import java.math.BigDecimal;
import java.util.Date;

public class Transaction {
    private Date transactionDate;
    private Account account;
    private TransactionType type;
    private BigDecimal balance;

    //TODO przejzec konstruktory bez parametrów.
    public Transaction() {
    }

    public Transaction(Date transactionDate, Account account, TransactionType type, BigDecimal balance) {
        this.transactionDate = transactionDate;
        this.account = account;
        this.type = type;
        this.balance = balance;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}