package com.tazine.jvm.classload;

import java.util.concurrent.TimeUnit;

/**
 * Test
 *
 * @author frank
 * @date 2018/3/24
 */
public class Test {

    public static void main(String[] args) throws Exception {

        Test t1 = new Test();
        Test t2 = new Test();
        Test t3 = new Test();
        TimeUnit.SECONDS.sleep(10);
        Class.forName("com.tazine.jvm.classload.ClassLoaderDemo");
        TimeUnit.DAYS.sleep(1);
    }
}
