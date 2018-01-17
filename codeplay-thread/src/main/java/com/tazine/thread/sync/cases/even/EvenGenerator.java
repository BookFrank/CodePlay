package com.tazine.thread.sync.cases.even;

/**
 * EvenGenerator
 *
 * @author frank
 * @since 1.0.0
 */
public class EvenGenerator extends IntGenerator {

    private int currentVal = 0;

    @Override
    public int next() {

        /**
         * 一个任务有可能在另一个任务执行第一个对currentVal的递增操作之后，
         * 但是没有执行第二个自增操作之前，调用next方法，这将使这个值处于不恰当地状态
         *
         * 递增程序自身也需要多个步骤，并且在递增过程中任务可能会被线程机制挂起，
         * 也就是说，在Java程序中，递增不是原子性的操作。
         */

        ++currentVal; // danger point here
        ++currentVal;
        return currentVal;
    }
}
