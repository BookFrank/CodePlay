package com.tazine.bank;

/**
 * Created by ly on 2017/9/7.
 * 账户实体类
 */
public class Account {


    private String name;

    private double balance;

    public Account(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public double fetch(double value) {
        if (balance >= value){
            balance = balance - value;
            return value;
        }else {
            double val = balance;
            balance = 0;
            System.out.println("余额不足");
            return val;
        }
    }

    public void save(double money){
        balance = balance + money;
    }


}
