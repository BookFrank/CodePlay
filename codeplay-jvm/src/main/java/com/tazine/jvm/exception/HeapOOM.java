package com.tazine.jvm.exception;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * VM Args: -Xms20m -Xms20m -XX:+HeapDumpOnOutOfMemoryError
 * Heap Out of Memory 堆溢出情况
 *
 * @author frank
 * @date 2017/12/18
 */
public class HeapOOM {

    private String name = "frank";

    public static void main(String[] args) {
        List<HeapOOM> list = new ArrayList<>();
        while (true) {
            //try {
            //    TimeUnit.MILLISECONDS.sleep(100);
            //} catch (InterruptedException e) {
            //    e.printStackTrace();
            //}
            list.add(new HeapOOM());
        }
    }
    // java -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError com.tazine.jvm.exception.HeapOOM
    // java -Xms10m -Xmx10m -XX:+HeapDumpOnOutOfMemoryError com.tazine.jvm.exception.HeapOOM
    // java -cp codeplay-jvm-1.0.0.jar -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError com.tazine.jvm.exception.HeapOOM
    // 出现错误：java.lang.OutOfMemoryErroe: Java heap space，因为所有Java对象的实例和数组都是在堆上分配内存的
}
