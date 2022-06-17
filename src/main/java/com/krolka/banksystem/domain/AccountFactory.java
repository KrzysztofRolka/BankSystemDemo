package com.krolka.banksystem.domain;

public enum AccountFactory {

    INDIVIDUAL {
        @Override
        public Account createAccount() {
            return new IndividualAccount();
        }
    },
    COMPANY {
        @Override
        public Account createAccount() {
            return new CompanyAccount();
        }
    };

    public abstract Account createAccount();
}



