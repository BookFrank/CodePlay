package com.tazine.jvm.loader.init;

/**
 * DeadLoopClass
 *
 * @author frank
 * @date 2017/12/12
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
