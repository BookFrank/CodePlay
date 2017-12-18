package com.tazine.thread.bank;

/**
 *
 */
public class Test {

    public static void main(String[] args) {
        Account account = new Account("kobe", 100);

        new DepositMoney(account, 100).start();
        new FetchMoney(account, 250).start();
        new DepositMoney(account, 50).start();
    }
}
