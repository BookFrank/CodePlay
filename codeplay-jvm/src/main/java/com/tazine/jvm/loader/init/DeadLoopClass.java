package com.tazine.jvm.loader.init;

/**
 * DeadLoopClass
 *
 * @author frank
 * @since 1.0.0
 */
public class DeadLoopClass {

    static {
        if (true) {
            System.out.println("DeadLoop Init...");
            while (true) {
            }
        }
    }
}
