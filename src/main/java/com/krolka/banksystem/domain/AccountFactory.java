package com.krolka.banksystem.domain;

//FACTORY PATTERN
public abstract class AccountFactory {

    public static Account createAccount(AccountType type, AccountCreateDto dto) {

        switch (type) {

            case INDIVIDUAL:
                return new IndividualAccount(dto.getFirstName(), dto.getLastName(), dto.isActive(), dto.getBalance());

            case BUSINESS:
                return new BusinessAccount(dto.getCompanyName(), dto.getTaxId(), dto.isActive(), dto.getBalance());
        }
        return null;
    }
}


