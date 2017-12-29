package com.tazine.thread.test;

class WindowThread extends Thread {

    private int leftTickets;

    private UserThread userThread;

    private String name;

    public WindowThread(String name) {
        this.name = name;
    }

    public WindowThread(String name, UserThread userThread) {
        this.name = name;
        this.userThread = userThread;
    }

    @Override
    public void run() {
//        while (leftTickets > 0) {
//            leftTickets--;
//            System.out.println(this.name + "卖出一张票，还有 " + leftTickets);
//            try {
//                sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
        while (userThread.getNum() > 0) {
            synchronized (userThread){
                userThread.setNum(userThread.getNum() - 1);
                System.out.println(this.name + "卖出一张票，还有 " + userThread.getNum());
            }
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class WindowRunnable implements Runnable {

    private volatile int leftTickets = 5;

    @Override
    public void run() {
        while (leftTickets > 0) {
            leftTickets--;
            System.out.println(Thread.currentThread().getName() + "卖出一张票，还有 " + leftTickets);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class UserThread {

    private int num = 6;

    public int getNum() {
        return num;
    }

    public void setNum(int num1) {
        num = num1;
    }

    public static void main(String[] args) {

        UserThread userThread = new UserThread();


        // Thread 方式创建线程
//        WindowThread window1 = new WindowThread("窗口-01");
//        WindowThread window2 = new WindowThread("窗口-02");
//        WindowThread window3 = new WindowThread("窗口-03");
        WindowThread window1 = new WindowThread("窗口-01", userThread);
        WindowThread window2 = new WindowThread("窗口-02", userThread);
        WindowThread window3 = new WindowThread("窗口-03", userThread);

        // Runnable 方式创建线程
//        WindowRunnable runnable = new WindowRunnable();
//        Thread window1 = new Thread(runnable, "柜台-01");
//        Thread window2 = new Thread(runnable, "柜台-02");
//        Thread window3 = new Thread(runnable, "柜台-03");

        window1.start();
        window2.start();
        window3.start();
    }
}
