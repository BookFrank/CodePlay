package com.tazine.thread.runnable;

/**
 * Thread vs Runnable 创建线程对比
 * @author 李扬
 */
public class VersusThread {

    private volatile int leftNum = 5;

    public int getLeftNum() {
        return leftNum;
    }

    public void setLeftNum(int leftNum) {
        this.leftNum = leftNum;
    }

    public static void main(String[] args) {

        VersusThread versus = new VersusThread();

        WindowRunnable01 runnable = new WindowRunnable01();

//        Thread window01 = new Thread(runnable, "窗口-01");
//        Thread window02 = new Thread(runnable, "窗口-02");
//        Thread window03 = new Thread(runnable, "窗口-03");

//        WindowThread01 window01 = new WindowThread01("窗口-01");
//        WindowThread01 window02 = new WindowThread01("窗口-02");
//        WindowThread01 window03 = new WindowThread01("窗口-03");

        WindowThread02 window01 = new WindowThread02("窗口-01",versus);
        WindowThread02 window02 = new WindowThread02("窗口-02",versus);
        WindowThread02 window03 = new WindowThread02("窗口-03",versus);


        window01.start();
        window02.start();
        window03.start();
    }

}


class WindowThread01 extends Thread{

    private String name;

    private int leftTickets = 5;

    public WindowThread01(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        while (leftTickets > 0){
            leftTickets--;
            System.out.println(this.name + "卖出一张票，还剩" + leftTickets);
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class WindowThread02 extends Thread{

    private VersusThread versusThread;

    private String name;

    public WindowThread02( String name,VersusThread versusThread) {
        this.versusThread = versusThread;
        this.name = name;
    }

    @Override
    public void run() {
        while (versusThread.getLeftNum() > 0){
            versusThread.setLeftNum(versusThread.getLeftNum() - 1);
            System.out.println(this.name + "卖出一张票，还剩" + versusThread.getLeftNum());
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        super.run();
    }
}

class WindowRunnable01 implements Runnable{

    private int leftTickets = 5;

    public void run() {
        while (leftTickets > 0){
            leftTickets--;
            System.out.println(Thread.currentThread().getName() + " 卖出一张票，还剩" + leftTickets);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}