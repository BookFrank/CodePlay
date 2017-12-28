package com.tazine.jvm.loader.init;

/**
 * Created by lina on 2017/12/28.
 *
 * @author frank
 * @since 1.0.0
 */
public class DeadLoopClass {

    static {
        if (true){
            System.out.println("DeadLoop Init...");
            while (true){}
        }
    }
}
