package com.tazine.thread.action;

/**
 * 线程的中断
 *
 * @author frank
 * @since 1.0.0
 */
public class InterruptDemo {

    /**
     * 线程Run设置while循环，通过中断标志中断循环来终止线程。
     *
     * @param args
     */
    public static void main(String[] args) {
        InterruptThread thread = new InterruptThread();
        thread.start();
        thread.interrupt();
    }
}


class InterruptThread extends Thread {

    private boolean isCountinue = true;

    @Override
    public void run() {
        while (isCountinue) {
            System.out.println("InterruptThread is running......");
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                //e.printStackTrace();
                System.out.println("当前线程被强制中断");
                isCountinue = false;
            }
        }
    }

    private void setCountinue(boolean flag) {
        isCountinue = flag;
    }
}
