package com.krolka.banksystem.strategy;

import com.krolka.banksystem.domain.Account;
import com.krolka.banksystem.domain.TransactionType;

import java.math.BigDecimal;

public class BusinessCommission implements Strategy {

    BigDecimal commission = BigDecimal.valueOf(10);
    @Override
    public BigDecimal subtractCommission(Account account, TransactionType type, BigDecimal amount) {

        account.setBalance(account.getBalance().subtract(commission));
        return  account.getBalance();
    }
}
