package com.krolka.banksystem.domain;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class AccountCreateDtoTest {

    AccountCreateDto testDto = AccountCreateDto.builder()
            .balance(BigDecimal.valueOf(1000))
            .companyName("CompanyName")
            .isActive(true)
            .taxId(12345)
            .firstName("Krzysiek")
            .lastName("Rolka")
            .bulid();

    @Test
    public void build_checkNewAccountCreateDto_balance() {
        assertEquals(0, testDto.getBalance().compareTo(BigDecimal.valueOf(1000)));
    }

    @Test
    public void build_checkNewAccountCreateDto_companyName() {
        assertTrue(testDto.getCompanyName().equals("CompanyName"));
    }

    @Test
    public void build_checkNewAccountCreateDto_isActive() {
        assertTrue(testDto.isActive() == true);
    }

    @Test
    public void build_checkNewAccountCreateDto_taxId() {
        assertTrue(testDto.getTaxId() == 12345);
    }

    @Test
    public void build_checkNewAccountCreateDto_firstName() {
        assertTrue(testDto.getFirstName().equals("Krzysiek"));
    }

    @Test
    public void build_checkNewAccountCreateDto_lastName() {
        assertTrue(testDto.getLastName().equals("Rolka"));
    }
}