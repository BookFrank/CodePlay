package com.tazine.thread.sync.n;

/**
 * 把自己锁住，同一时间只会有一个在执行
 *
 * @author frank
 * @date 2017/9/7
 */
public class Thread01 implements Runnable {

    @Override
    public void run() {
        // 把自己锁住，可以保证同一时间最多有一个线程执行
        // run部分的代码必须全部执行完成才会走下一个线程

        System.out.println(this.getClass().getCanonicalName());
        synchronized (this) {
            for (int i = 1; i < 6; i++) {
                System.out.println(Thread.currentThread().getName() + "---" + i);
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
