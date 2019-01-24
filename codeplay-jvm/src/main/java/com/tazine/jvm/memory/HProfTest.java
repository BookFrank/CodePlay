package com.tazine.jvm.memory;

/**
 * HProfTest
 * java -agentlib:hprof=cpu=times,interval=10
 *
 * @author frank
 * @date 2019/01/24
 */
public class HProfTest {

    public static void main(String[] args) throws InterruptedException {
        HProfTest test = new HProfTest();
        test.slowMethod();
        test.slowerMethod();
    }

    private void slowMethod() throws InterruptedException {
        Thread.sleep(1000);
    }

    private void slowerMethod() throws InterruptedException {
        Thread.sleep(10000);
    }
}
