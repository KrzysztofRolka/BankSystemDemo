package com.krolka.banksystem.strategy;

import com.krolka.banksystem.domain.Account;
import com.krolka.banksystem.domain.TransactionType;

import java.math.BigDecimal;

public class Context {

    private Strategy strategy;

    public Context(Strategy strategy){
        this.strategy = strategy;
    }

    public BigDecimal executeStrategy(Account account, TransactionType type,BigDecimal amount){
        return  strategy.subtractCommission(account,type,amount);
    }
}
