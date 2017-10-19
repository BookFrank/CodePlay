package com.tazine.bank;

/**
 * Created by lina on 2017/9/7.
 */
public class Test {


    public static void main(String[] args) {

        Account account = new Account("liyang", 100);

        new Save(account, 200).start();
        new Save(account, 50).start();
        new Fetch(account, 200).start();

    }


}
