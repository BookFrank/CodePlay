package com.tazine.thread.sync.cases.even;

/**
 * IntGenerator
 *
 * @author frank
 * @since 1.0.0
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
