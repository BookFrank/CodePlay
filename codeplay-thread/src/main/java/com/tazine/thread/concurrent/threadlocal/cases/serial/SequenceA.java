package com.tazine.thread.concurrent.threadlocal.cases.serial;

/**
 * Created by lina on 2018/1/8.
 *
 * @author frank
 * @since 1.0.0
 */
public class SequenceA implements SequenceGenerator {

    private static int number = 0;

    @Override
    public int produce() {
        number++;
        return number;
    }
}
