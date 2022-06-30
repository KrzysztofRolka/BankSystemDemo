package com.krolka.banksystem.strategy;

import com.krolka.banksystem.domain.Account;
import com.krolka.banksystem.domain.TransactionType;

import java.math.BigDecimal;

public interface Strategy {
    public BigDecimal subtractCommission(Account account, TransactionType type, BigDecimal amount);
}
