package com.krolka.banksystem.service;

import com.krolka.banksystem.domain.Account;
import com.krolka.banksystem.domain.Transaction;
import com.krolka.banksystem.domain.TransactionType;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class BankingService {

    private static volatile BankingService instance = null;
    //SINGLETON
    private BankingService() {
        if (instance != null) {
            throw new RuntimeException("Not allowed. Please use getInstance() method");
        }
    }

    public static BankingService getInstance() {
        if (instance == null) {
            synchronized (BankingService.class) {
                if (instance == null) {
                    instance = new BankingService();
                }
            }
        }
        return instance;
    }

    BigDecimal actualBalance(Account account) {
        if (account.isActive()) {
            return account.getBalance();
        }
        return null;
    }

    public BigDecimal withdraw(Account account, BigDecimal amount) {
        if (account.isActive()) {
            if (!(account.getBalance().compareTo(amount) == -1)) {
                account.setBalance(account.getBalance().min(amount));
                account.setTransactions(createTransaction(account, new Date(), TransactionType.WITHDRAW,account.getBalance()));
                return account.getBalance();
            }
        }
        return account.getBalance();
    }

    public BigDecimal deposit(Account account, BigDecimal amount) {
        if (account.isActive()) {
            account.setBalance(account.getBalance().add(amount));
            account.setTransactions(createTransaction(account, new Date(), TransactionType.DEPOSIT, account.getBalance()));
        }
        return account.getBalance();
    }

    private List<Transaction> createTransaction(Account account, Date transactionDate, TransactionType type, BigDecimal balance) {
        List<Transaction> transactions = account.getTransactions();
        transactions.add(new Transaction(transactionDate, type, balance));
        return transactions;
    }
}
