package com.tazine.base.cas;

import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * ABA 问题解决
 *
 * @author frank
 * @date 2019/01/28
 */
public class AtomicStampedReferenceTest {

    private static AtomicStampedReference<Integer> atomicStampedReference = new AtomicStampedReference<>(0, 0);

    public static void main(String[] args) throws InterruptedException {
        final int stamp = atomicStampedReference.getStamp();
        final Integer reference = atomicStampedReference.getReference();

        Thread t1 = new Thread(() -> System.out.println(reference + "-" + stamp + "-" + atomicStampedReference.compareAndSet(reference, reference + 10, stamp, stamp + 1)));

        Thread t2 = new Thread(() -> {
            Integer refer = atomicStampedReference.getReference();
            System.out.println(refer + "-" + stamp + "-" + atomicStampedReference.compareAndSet(refer, refer + 10, stamp, stamp + 1));
        });

        t1.start();
        t1.join();

        t2.start();
        t2.join();

        System.out.println(atomicStampedReference.getReference());
        System.out.println(atomicStampedReference.getStamp());

        // Thread.join 的目的是为了线程插队，保证先执行线程内的逻辑，最后再打印相关的信息。
    }
}
