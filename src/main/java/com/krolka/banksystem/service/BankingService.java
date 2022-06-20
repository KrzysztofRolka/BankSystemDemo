package com.krolka.banksystem.service;

import com.krolka.banksystem.domain.Account;
import com.krolka.banksystem.domain.Transaction;
import com.krolka.banksystem.domain.TransactionType;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

//TODO implement log4j, createTransaction, usunac of z nazw
public class BankingService {

    BigDecimal actualBalance(Account account) {
        if (account.isActive() == true) {
            return account.getBalance();
        }
        return null;
    }

    public BigDecimal withdraw(Account account, BigDecimal amount) {
        if (account.isActive()) {
            if (!(account.getBalance().compareTo(amount) == -1)) {
                account.setBalance(account.getBalance().min(amount));

                createTransaction(new Date(), account, TransactionType.WITHDRAW, account.getBalance());

                return account.getBalance();
            }
        }
        return account.getBalance();
    }

    public BigDecimal deposit(Account account, BigDecimal amount) {
        if (account.isActive()) {
            account.setBalance(account.getBalance().add(amount));
            createTransaction(new Date(), account, TransactionType.DEPOSIT, account.getBalance());
        }
        return account.getBalance();
    }

    private Transaction createTransaction(Date transactionDate, Account account, TransactionType type, BigDecimal balance) {
        return new Transaction(transactionDate, account, type, balance);
    }

    //TODO add body to method
    public List<Transaction> historyOfTransaction() {

        return null;
    }
}
