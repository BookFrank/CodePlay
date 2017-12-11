package com.tazine.thread.action;

/**
 * 线程的加入 join
 *
 * @author Frank
 * @since 1.0.0
 */
public class JoinDemo {

    /**
     * 当某个线程使用 join() 方法加入到另一个线程时，另一个线程会等待该线程执行完毕再继续执行
     *
     * @param args
     */
    public static void main(String[] args) {

        JoinThread thread = new JoinThread();

        System.out.println("main 线程执行");

        try {
            thread.start();
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("main 线程执行完毕");
    }


}

class JoinThread extends Thread {

    @Override
    public void run() {
        while (true) {
            System.out.println("JoinThread 工作中......");
            try {
                sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            break;
        }
        System.out.println("JoinThread 线程执行完毕");
    }
}
