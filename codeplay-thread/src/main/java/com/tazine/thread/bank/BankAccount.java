package com.tazine.thread.bank;

/**
 *
 *
 * @author frank
 * @since 1.0.0
 */
public class BankAccount {

    private String name;
    private double balance;

    public BankAccount(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    public void deposit(double money){
        balance+=money;
    }

    public void fetch(double money){
        if (balance >= money){
            balance-=money;
        }else {
            System.out.println(" 您的余额不足 ");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
