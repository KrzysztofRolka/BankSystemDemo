package com.krolka.banksystem.domain;

public abstract class AccountDecorator extends Account {

    protected Account account;

    public AccountDecorator(Account account){
        this.account = account;
    }

    @Override
    public String sign(){
        return account.sign();
    }

}
