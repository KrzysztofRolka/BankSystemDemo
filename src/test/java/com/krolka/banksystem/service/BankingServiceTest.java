package com.krolka.banksystem.service;

import com.krolka.banksystem.domain.*;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BankingServiceTest {

    BankingService underTest = new BankingService();

    @Test
    void actualBalance_NonActiveAccount_returnNull() {
        //GIVEN
        final Account testAccount = new IndividualAccount("Krzysiek", "Rolka", false, BigDecimal.valueOf(1000));
        //WHEN
        BigDecimal actualBalance = underTest.actualBalance(testAccount);
        //THEN
        assertNull(actualBalance);
    }

    @Test
    void actualBalance_ActiveAccount_returnBalance() {
        //GIVEN
        final Account testAccount = new IndividualAccount("Krzysiek", "Rolka", true, BigDecimal.valueOf(1000));
        //WHEN
        BigDecimal actualBalance = underTest.actualBalance(testAccount);
        //THEN
        assertThat(actualBalance).isEqualByComparingTo(BigDecimal.valueOf(1000));
    }

    @Test
    public void withdraw_NonActiveAccount_doNothing() {
        //GIVEN
        final Account testAccount = new IndividualAccount("Krzysiek", "Rolka", false, BigDecimal.valueOf(1000));
        //WHEN
        BigDecimal actualBalance = underTest.withdraw(testAccount, BigDecimal.valueOf(500));
        //THEN
        assertThat(actualBalance.compareTo(BigDecimal.valueOf(1000)));
    }


    @Test
    public void withdraw_ActiveAccount_decreaseBalance() {
        //GIVEN
        //final Account testAccount = new IndividualAccount("Krzysiek", "Rolka", true, BigDecimal.valueOf(1000));
        final Account testAccount = AccountFactory.COMPANY.createAccount();
        testAccount.setBalance(BigDecimal.valueOf(1000));
        //WHEN
        BigDecimal actualBalacnce = underTest.withdraw(testAccount, BigDecimal.valueOf(500));
        //THEN
        assertThat(actualBalacnce.compareTo(BigDecimal.valueOf(500)));
    }

    @Test
    public void withdraw_BalanceLowerThenAmount_DoNothing() {
        //GIVEN
        final Account testAccount = new IndividualAccount("Krzysiek", "Rolka", true, BigDecimal.valueOf(1000));
        //WHEN
        BigDecimal actualBalance = underTest.withdraw(testAccount, BigDecimal.valueOf(1500));
        //THEN
        assertThat(actualBalance.compareTo(BigDecimal.valueOf(1000)));
    }

    @Test
    public void deposit_NonActiveAccount_DoNothing() {
        //GIVEN
        final Account testAccount = new IndividualAccount("Krzysiek", "Rolka", false, BigDecimal.valueOf(1000));
        //WHEN
        BigDecimal actualBalance = underTest.deposit(testAccount, BigDecimal.valueOf(500));
        //THEN
        assertThat(actualBalance.compareTo(BigDecimal.valueOf(1000)));
    }

    @Test
    public void deposit_ActiveAccount_IncreaseBalance() {
        //GIVEN
        final Account testAccount = new IndividualAccount("Krzysiek", "Rolka", true, BigDecimal.valueOf(1000));
        //WHEN
        BigDecimal actualBalance = underTest.deposit(testAccount, BigDecimal.valueOf(500));
        //THEN
        assertThat(actualBalance.compareTo(BigDecimal.valueOf(1500)));
    }

    @Test
    public void addTransaction_ActiveAccount_IncreaseBalance() {
        //GIVEN
        //WHEN
        //THEN
        assertTrue(false);
    }
}