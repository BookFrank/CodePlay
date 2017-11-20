package com.tazine.thread;

/**
 * synchronized 可以实现原子性与可见性
 * @author Frank
 */
public class SynchronizedDemo {

    private boolean ready =false;

    private int result = 0;
    private int number = 1;

    private void write(){
        ready = true;
        number = 2;
    }

    private void read(){
        if (ready){
            result = number*3;
        }
        System.out.println("Result的值为：" + result);
    }


    private class ReadWriteThread extends Thread{
        @Override
        public void run() {
            if (ready){
                read();
            }else {
                write();
            }
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        SynchronizedDemo s = new SynchronizedDemo();

        s.new ReadWriteThread().start();
        s.new ReadWriteThread().start();
    }



}
