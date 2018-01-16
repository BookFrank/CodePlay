package com.tazine.thread.cooperate.cases.bank;

/**
 * Created by lina on 2017/12/18.
 */
public class DepositMoney extends Thread{

    private BankAccount bankAccount;
    private double money;

    public DepositMoney(BankAccount bankAccount, double money) {
        this.bankAccount = bankAccount;
        this.money = money;
    }

    @Override
    public void run() {
        double balance = bankAccount.getBalance();
        bankAccount.deposit(money);
        try {
            sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("当前余额为 " + balance + "，存入 " + money + "，结余：" + bankAccount.getBalance());

    }
}
