package com.krolka.banksystem.strategy;

import com.krolka.banksystem.domain.Account;
import com.krolka.banksystem.domain.TransactionType;

import java.math.BigDecimal;

public class IndividualCommission implements Strategy {

    @Override
    public BigDecimal subtractCommission(Account account, TransactionType type, BigDecimal amount) {

        if(type == TransactionType.WITHDRAW){
            return null;
        }

        account.setBalance(account.getBalance().subtract(amount.multiply(BigDecimal.valueOf(0.05))));
        return account.getBalance();
    }
}
