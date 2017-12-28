package com.tazine.thread.lock;

/**
 * ClassLock & ObjectLock
 *
 * @author frank
 * @since 1.0.0
 */
public class LockKind {

    private Object obj;

    private static synchronized void method1() {
    }

    private void method2() {
        synchronized (LockKind.class) {

        }
    }

    private synchronized void method3() {
    }

    private void method4() {
        synchronized (this) {

        }
    }

    private void method5() {
        synchronized (obj) {

        }
    }


}
