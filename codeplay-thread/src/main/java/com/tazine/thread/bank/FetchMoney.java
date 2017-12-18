package com.tazine.thread.bank;

/**
 */
public class FetchMoney extends Thread{

    private Account account;
    private double money;

    public FetchMoney(Account account, double money) {
        this.account = account;
        this.money = money;
    }

    @Override
    public void run() {
        double balance = account.getBalance();
        account.fetch(money);
        System.out.println("当前余额为 " + balance + "，取出 " + money + "，结余：" + account.getBalance());
    }
}
