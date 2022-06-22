package com.krolka.banksystem.domain;

import java.math.BigDecimal;
import java.util.Date;

public class Transaction {
    private Date transactionDate;
    private TransactionType type;
    private BigDecimal balance;

    public Transaction(Date transactionDate, TransactionType type, BigDecimal balance) {
        this.transactionDate = transactionDate;
        this.type = type;
        this.balance = balance;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
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