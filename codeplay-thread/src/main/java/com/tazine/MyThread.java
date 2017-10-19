package com.tazine;

/**
 * Created by lina on 2017/8/23.
 */
public class MyThread extends Thread {


    @Override
    public void run() {

        while (true){
            System.out.println("线程答应");
            try {
                sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
