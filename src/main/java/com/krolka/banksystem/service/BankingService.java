package com.krolka.banksystem.service;

import com.krolka.banksystem.domain.Account;

import java.math.BigDecimal;

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
                return account.getBalance();
            }
        }
        return account.getBalance();
    }

    public BigDecimal deposit(Account account, BigDecimal amount) {
        if (account.isActive()) {
            account.setBalance(account.getBalance().add(amount));
        }
        return account.getBalance();
    }

}
