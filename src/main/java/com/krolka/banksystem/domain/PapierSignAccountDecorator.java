package com.krolka.banksystem.domain;

public class PapierSignAccountDecorator extends AccountDecorator{
    public PapierSignAccountDecorator(Account account) {
        super(account);
    }

    @Override
    public String sign() {
        return super.sign() + "Sign method: papier. ";
    }
}
