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
        final AccountCreateDto dto = new AccountCreateDto()
                .setFirstName("Krzysiek")
                .setLastName("Rolka")
                .setActive(false)
                .setBalance(BigDecimal.valueOf(1000));
        final Account testAccount = AccountFactory.createAccount(AccountType.INDIVIDUAL,dto);
        //WHEN
        BigDecimal actualBalance = underTest.actualBalance(testAccount);
        //THEN
        assertNull(actualBalance);
    }

    @Test
    void actualBalance_ActiveAccount_returnBalance() {
        //GIVEN
        final AccountCreateDto dto = new AccountCreateDto()
                .setFirstName("Krzysiek")
                .setLastName("Rolka")
                .setActive(true)
                .setBalance(BigDecimal.valueOf(1000));
        final Account testAccount = AccountFactory.createAccount(AccountType.INDIVIDUAL,dto);
        //WHEN
        BigDecimal actualBalance = underTest.actualBalance(testAccount);
        //THEN
        assertThat(actualBalance).isEqualByComparingTo(BigDecimal.valueOf(1000));
    }

    @Test
    public void withdraw_NonActiveAccount_doNothing() {
        //GIVEN
        final AccountCreateDto dto = new AccountCreateDto()
                .setFirstName("Krzysiek")
                .setLastName("Rolka")
                .setActive(false)
                .setBalance(BigDecimal.valueOf(1000));
        final Account testAccount = AccountFactory.createAccount(AccountType.INDIVIDUAL,dto);
        //WHEN
        BigDecimal actualBalance = underTest.withdraw(testAccount, BigDecimal.valueOf(500));
        //THEN
        assertThat(actualBalance.compareTo(BigDecimal.valueOf(1000)));
    }


    @Test
    public void withdraw_ActiveAccount_decreaseBalance() {
        //GIVEN
        final AccountCreateDto dto = new AccountCreateDto()
                .setFirstName("Krzysiek")
                .setLastName("Rolka")
                .setActive(true)
                .setBalance(BigDecimal.valueOf(1000));
        final Account testAccount = AccountFactory.createAccount(AccountType.INDIVIDUAL,dto);
        //WHEN
        BigDecimal actualBalance = underTest.withdraw(testAccount, BigDecimal.valueOf(500));
        //THEN
        assertThat(actualBalance.compareTo(BigDecimal.valueOf(500)));
    }

    @Test
    public void withdraw_BalanceLowerThenAmount_DoNothing() {
        //GIVEN
        final AccountCreateDto dto = new AccountCreateDto()
                .setCompanyName("CompanyName")
                .setTaxId(123456789)
                .setActive(true)
                .setBalance(BigDecimal.valueOf(1000));
        final Account testAccount = AccountFactory.createAccount(AccountType.COMPANY,dto);
        //WHEN
        BigDecimal actualBalance = underTest.withdraw(testAccount, BigDecimal.valueOf(1500));
        //THEN
        assertThat(actualBalance.compareTo(BigDecimal.valueOf(1000)));
    }

    @Test
    public void deposit_NonActiveAccount_DoNothing() {
        //GIVEN
        final AccountCreateDto dto = new AccountCreateDto()
                .setCompanyName("CompanyName")
                .setTaxId(123456789)
                .setActive(false)
                .setBalance(BigDecimal.valueOf(1000));
        final Account testAccount = AccountFactory.createAccount(AccountType.COMPANY,dto);
        //WHEN
        BigDecimal actualBalance = underTest.deposit(testAccount, BigDecimal.valueOf(500));
        //THEN
        assertThat(actualBalance.compareTo(BigDecimal.valueOf(1000)));
    }

    @Test
    public void deposit_ActiveAccount_IncreaseBalance() {
        //GIVEN
        final AccountCreateDto dto = new AccountCreateDto()
                .setCompanyName("CompanyName")
                .setTaxId(123456789)
                .setActive(true)
                .setBalance(BigDecimal.valueOf(1000));
        final Account testAccount = AccountFactory.createAccount(AccountType.COMPANY,dto);
        //WHEN
        BigDecimal actualBalance = underTest.deposit(testAccount, BigDecimal.valueOf(500));
        //THEN
        assertThat(actualBalance.compareTo(BigDecimal.valueOf(1500)));
    }
}