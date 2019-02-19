package com.tazine.thread.cooperate.cases.bank;

/**
 * Test
 *
 * @author frank
 * @date 2017/12/18
 */
public class Test {

    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount("kobe", 100);

        new DepositMoney(bankAccount, 100).start();
        new FetchMoney(bankAccount, 250).start();
        new DepositMoney(bankAccount, 50).start();
    }
}
