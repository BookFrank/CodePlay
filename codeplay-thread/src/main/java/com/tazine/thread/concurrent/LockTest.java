package com.tazine.thread.concurrent;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by lina on 2018/1/16.
 *
 * @author frank
 * @since 1.0.0
 */
public class LockTest {
    public static void main(String[] args) {


    }
}

class Outputer{

    private Lock lock = new ReentrantLock();

    public void print(String words){
        lock.lock();
        try {
            for (int i=0;i<words.length();i++){
                System.out.print(words.charAt(i));
            }
            System.out.print(" ");
        } finally {
            /**
             * 为了保证锁最终被释放(即使发生异常情况)，要把互斥区放在try内，释放锁放在finally内
             */
            lock.unlock();
        }
    }
}
