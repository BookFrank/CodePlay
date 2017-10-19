package com.tazine.bank;

/**
 * Created by ly on 2017/9/7.
 */
public class Save extends Thread {

    private Account account;

    private double money;

    public Save(Account account, double money) {
        this.account = account;
        this.money = money;
    }

    @Override
    public void run() {

        synchronized (this.account){
            double balance = this.account.getBalance();
            this.account.save(money);

            try {
                sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(this.account.getName() + "账户：现有" + balance + " 存入：" + this.money + " 目前：" + this.account.getBalance());

        }
    }
}
