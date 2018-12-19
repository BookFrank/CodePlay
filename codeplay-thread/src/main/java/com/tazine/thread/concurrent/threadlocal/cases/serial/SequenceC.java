package com.tazine.thread.concurrent.threadlocal.cases.serial;

import com.tazine.thread.concurrent.threadlocal.MyThreadLocal;

/**
 * Created by lina on 2018/1/8.
 *
 * @author frank
 * @date 2018/1/8
 */
public class SequenceC implements SequenceGenerator {

    private static MyThreadLocal<Integer> numContainer = new MyThreadLocal<Integer>(){
        @Override
        protected Integer initialValue() {
            return 0;
        }
    };

    @Override
    public int produce() {
        numContainer.set(numContainer.get() + 1);
        return numContainer.get();
    }
}
