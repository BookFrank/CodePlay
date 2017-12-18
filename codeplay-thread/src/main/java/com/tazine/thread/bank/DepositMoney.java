package com.tazine.thread.bank;

/**
 * Created by lina on 2017/12/18.
 */
public class DepositMoney extends Thread{

    private Account account;
    private double money;

    public DepositMoney(Account account, double money) {
        this.account = account;
        this.money = money;
    }

    @Override
    public void run() {
        double balance = account.getBalance();
        account.deposit(money);
        try {
            sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("当前余额为 " + balance + "，存入 " + money + "，结余：" + account.getBalance());

    }
}
