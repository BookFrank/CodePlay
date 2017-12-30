package com.tazine.thread.sleepWait;

import com.tazine.App;

/**
 * Created by ly on 2017/8/25.
 */
public class Test {


    public static void main(String[] args)
    {
        new Thread(new Thread01()).start();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(new Thread02()).start();
    }



    private static class Thread01 implements Runnable
    {

        public void run() {
            synchronized (App.class){
                System.out.println("Entered thread01");
                System.out.println("Thread01 is waiting");

                try {
                    App.class.wait();
                    //Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Thread01 wait end");
                System.out.println("Thread01 is over");
            }
        }
    }

    private static class Thread02 implements Runnable{

        public void run() {

            synchronized (App.class){
                System.out.println("-----Entered thread02");
                System.out.println("-----Thread02 is sleep");
                App.class.notify();
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("-----Thread02 sleep end");
                System.out.println("-----Thread02 is over");
            }

        }
    }




}
