package com.krolka.banksystem.domain;

public abstract class AccountFactory {

    public static Account createAccount(AccountType type, AccountCreateDto dto) {

        switch (type) {

            case INDIVIDUAL:
                return new IndividualAccount(dto.getFirstName(), dto.getLastName(), dto.isActive(), dto.getBalance());

            case COMPANY:
                return new CompanyAccount(dto.getCompanyName(), dto.getTaxId(), dto.isActive(), dto.getBalance());
        }
        return null;
    }
}


