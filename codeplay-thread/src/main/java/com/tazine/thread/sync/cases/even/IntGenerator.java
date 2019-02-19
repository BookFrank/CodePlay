package com.tazine.thread.sync.cases.even;

/**
 * IntGenerator
 *
 * @author frank
 * @date 2018/1/17
 */
public abstract class IntGenerator {
    private volatile boolean canceled = false;

    public abstract int next();

    public void cancel() {
        canceled = true;
    }

    public Boolean isCanceled() {
        return canceled;
    }
}
