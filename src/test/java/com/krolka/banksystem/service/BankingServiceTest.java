package com.krolka.banksystem.service;

import com.krolka.banksystem.domain.*;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;

class BankingServiceTest {

    BankingService underTest = BankingService.getInstance();

    @Test
    void actualBalance_NonActiveAccount_returnNull() {
        //GIVEN
        final AccountCreateDto dto = AccountCreateDto.builder()
                .firstName("Krzysiek")
                .lastName("Rolka")
                .isActive(false)
                .balance(BigDecimal.valueOf(1000))
                .bulid();
        final Account testAccount = AccountFactory.createAccount(AccountType.INDIVIDUAL, dto);
        //WHEN
        BigDecimal actualBalance = underTest.actualBalance(testAccount);
        //THEN
        assertNull(actualBalance);
    }

    @Test
    void actualBalance_ActiveAccount_returnBalance() {
        //GIVEN
        final AccountCreateDto dto = AccountCreateDto.builder()
                .firstName("Krzysiek")
                .lastName("Rolka")
                .isActive(true)
                .balance(BigDecimal.valueOf(1000))
                .bulid();
        final Account testAccount = AccountFactory.createAccount(AccountType.INDIVIDUAL, dto);
        //WHEN
        BigDecimal actualBalance = underTest.actualBalance(testAccount);
        //THEN
        assertThat(actualBalance).isEqualByComparingTo(BigDecimal.valueOf(1000));
    }

    @Test
    public void withdraw_NonActiveAccount_doNothing() {
        //GIVEN
        final AccountCreateDto dto = AccountCreateDto.builder()
                .firstName("Krzysiek")
                .lastName("Rolka")
                .isActive(false)
                .balance(BigDecimal.valueOf(1000))
                .bulid();
        final Account testAccount = AccountFactory.createAccount(AccountType.INDIVIDUAL, dto);
        //WHEN
        BigDecimal actualBalance = underTest.withdraw(testAccount, BigDecimal.valueOf(500));
        //THEN
        assertThat(actualBalance.compareTo(BigDecimal.valueOf(1000)));
    }


    @Test
    public void withdraw_ActiveAccount_decreaseBalance() {
        //GIVEN
        final AccountCreateDto dto = AccountCreateDto.builder()
                .firstName("Krzysiek")
                .lastName("Rolka")
                .isActive(true)
                .balance(BigDecimal.valueOf(1000))
                .bulid();
        final Account testAccount = AccountFactory.createAccount(AccountType.INDIVIDUAL, dto);
        //WHEN
        BigDecimal actualBalance = underTest.withdraw(testAccount, BigDecimal.valueOf(500));
        //THEN
        assertThat(actualBalance.compareTo(BigDecimal.valueOf(500)));
    }

    @Test
    public void withdraw_BalanceLowerThenAmount_DoNothing() {
        //GIVEN
        final AccountCreateDto dto = AccountCreateDto.builder()
                .companyName("CompanyName")
                .taxId(123456789)
                .isActive(true)
                .balance(BigDecimal.valueOf(1000))
                .bulid();
        final Account testAccount = AccountFactory.createAccount(AccountType.BUSINESS, dto);
        //WHEN
        BigDecimal actualBalance = underTest.withdraw(testAccount, BigDecimal.valueOf(1500));
        //THEN
        assertThat(actualBalance.compareTo(BigDecimal.valueOf(1000)));
    }

    @Test
    public void deposit_NonActiveAccount_DoNothing() {
        //GIVEN
        final AccountCreateDto dto = AccountCreateDto.builder()
                .companyName("CompanyName")
                .taxId(123456789)
                .isActive(false)
                .balance(BigDecimal.valueOf(1000))
                .bulid();
        final Account testAccount = AccountFactory.createAccount(AccountType.BUSINESS, dto);
        //WHEN
        BigDecimal actualBalance = underTest.deposit(testAccount, BigDecimal.valueOf(500));
        //THEN
        assertThat(actualBalance.compareTo(BigDecimal.valueOf(1000)));
    }

    @Test
    public void deposit_ActiveAccount_IncreaseBalance() {
        //GIVEN
        final AccountCreateDto dto = AccountCreateDto.builder()
                .companyName("CompanyName")
                .taxId(123456789)
                .isActive(true)
                .balance(BigDecimal.valueOf(1000))
                .bulid();
        final Account testAccount = AccountFactory.createAccount(AccountType.BUSINESS, dto);
        //WHEN
        BigDecimal actualBalance = underTest.deposit(testAccount, BigDecimal.valueOf(500));
        //THEN
        assertThat(actualBalance.compareTo(BigDecimal.valueOf(1500)));
    }

    @Test
    public void createTransaction_Depostit_createNewTransaction() {
        //GIVEN
        final AccountCreateDto dto = AccountCreateDto.builder()
                .companyName("CompanyName")
                .taxId(123456789)
                .isActive(true)
                .balance(BigDecimal.valueOf(1000))
                .bulid();
        final Account testAccount = AccountFactory.createAccount(AccountType.BUSINESS, dto);
        //WHEN
        underTest.deposit(testAccount, BigDecimal.valueOf(500));
        underTest.withdraw(testAccount, BigDecimal.valueOf(500));
        //THEN
        assertFalse(testAccount.getTransactions().isEmpty());
        System.out.println(testAccount.getTransactions().stream().count());
    }

    @Test
    public void sign_businessAccountViaPapier() {
        //GIVEN
        final AccountCreateDto dto = AccountCreateDto.builder()
                .companyName("Nestle")
                .taxId(123456789)
                .isActive(true)
                .balance(BigDecimal.valueOf(1000))
                .bulid();
        final Account testAccount = new PapierSignAccountDecorator(AccountFactory.createAccount(AccountType.BUSINESS, dto));
        //WHEN
        final String sign = testAccount.sign();
        //THEN
        assertThat(sign).isEqualTo("Nestle CEO must sign the documents. Sign method: papier. ");
    }

    @Test
    public void sign_businessAccountViaPapierAndESign() {
        //GIVEN
        final AccountCreateDto dto = AccountCreateDto.builder()
                .companyName("Nestle")
                .taxId(123456789)
                .isActive(true)
                .balance(BigDecimal.valueOf(1000))
                .bulid();
        final Account testAccount = new InternetSignAccountDecorator(new PapierSignAccountDecorator(AccountFactory.createAccount(AccountType.BUSINESS, dto)));
        //WHEN
        final String sign = testAccount.sign();
        //THEN
        assertThat(sign).isEqualTo("Nestle CEO must sign the documents. Sign method: papier. Sign method: e-sign. ");
    }
    @Test
    public void sign_individualAccountViaESignAndPapier() {
        //GIVEN
        final AccountCreateDto dto = AccountCreateDto.builder()
                .firstName("Krzysiek")
                .lastName("Rolka")
                .isActive(true)
                .balance(BigDecimal.valueOf(1000))
                .bulid();
        final Account testAccount = new PapierSignAccountDecorator(new InternetSignAccountDecorator(AccountFactory.createAccount(AccountType.INDIVIDUAL, dto)));
        //WHEN
        final String sign = testAccount.sign();
        //THEN
        assertThat(sign).isEqualTo("Krzysiek Rolka must sign the documents. Sign method: e-sign. Sign method: papier. ");
    }
    @Test
    public void sign_individualAccountViaESign() {
        //GIVEN
        final AccountCreateDto dto = AccountCreateDto.builder()
                .firstName("Krzysiek")
                .lastName("Rolka")
                .isActive(true)
                .balance(BigDecimal.valueOf(1000))
                .bulid();
        final Account testAccount = new InternetSignAccountDecorator(AccountFactory.createAccount(AccountType.INDIVIDUAL, dto));
        //WHEN
        final String sign = testAccount.sign();
        //THEN
        assertThat(sign).isEqualTo("Krzysiek Rolka must sign the documents. Sign method: e-sign. ");
    }

    @Test
    public void logout_internetSign(){
        final AccountCreateDto dto = AccountCreateDto.builder()
                .firstName("Krzysiek")
                .lastName("Rolka")
                .isActive(true)
                .balance(BigDecimal.valueOf(1000))
                .bulid();
        final Account testAccount = new InternetSignAccountDecorator(AccountFactory.createAccount(AccountType.INDIVIDUAL, dto));
        //WHEN
        final String logout = ((InternetSignAccountDecorator) testAccount).logout();
        //THEN
        assertThat(logout).isEqualTo("Logout Successful!");
    }
}

