package com.tazine.thread.cooperate.cases.bank;

/**
 * FetchMoney
 *
 * @author frank
 * @date 2017/12/18
 */
public class FetchMoney extends Thread {

    private BankAccount bankAccount;
    private double money;

    public FetchMoney(BankAccount bankAccount, double money) {
        this.bankAccount = bankAccount;
        this.money = money;
    }

    @Override
    public void run() {
        double balance = bankAccount.getBalance();
        bankAccount.fetch(money);
        System.out.println("当前余额为 " + balance + "，取出 " + money + "，结余：" + bankAccount.getBalance());
    }
}
