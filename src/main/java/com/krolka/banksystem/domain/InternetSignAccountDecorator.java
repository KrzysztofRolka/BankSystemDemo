package com.krolka.banksystem.domain;

public class InternetSignAccountDecorator extends AccountDecorator{

    public InternetSignAccountDecorator(Account account) {
        super(account);
    }

    @Override
    public String sign() {
        return super.sign() +"Sign method: e-sign. ";
    }

    public String logout(){
        return "Logout Successful!";
    }
}
