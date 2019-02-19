package com.tazine.thread.sync.cases.even;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * MutexGenerator 互斥生成器
 *
 * @author frank
 * @date 2018/1/17
 */
public class MutexGenerator extends IntGenerator {

    private int currentVal = 0;
    private Lock lock = new ReentrantLock();

    @Override
    public int next() {

        /**
         * 尽管try-finally所需的代码比synchronized关键字要多，但是这也代表了显式的Lock对象的优点
         * 如果在使用synchronized关键字时，某些事物失败了，那么就会抛出一个异常。
         * 但是你没有任何机会做清理工作，以维护系统使其处于良好状态。
         * 有了显式的Lock对象，你就可以使用finally子句将系统维护在正确的状态了。
         */

        lock.lock();
        try {
            ++currentVal;
            Thread.yield();
            ++currentVal;
            return currentVal;
        } finally {
            lock.unlock();
        }
    }
}
