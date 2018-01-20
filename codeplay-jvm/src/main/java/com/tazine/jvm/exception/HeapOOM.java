package com.tazine.jvm.exception;

import java.util.ArrayList;
import java.util.List;

/**
 * VM Args: -Xms20m -Xms20m -XX:+HeapDumpOnOutOfMemoryError
 * Heap Out of Memory 堆溢出情况
 *
 * @author frank
 * @since 1.0.0
 */
public class HeapOOM {

    private String name = "frank";

    public static void main(String[] args) {
        List<HeapOOM> list = new ArrayList<>();
        while (true) {
            list.add(new HeapOOM());
        }
    }
    // java -Xms20m -Xms20m -XX:+HeapDumpOnOutOfMemoryError com.tazine.jvm.exception.HeapOOM
    // 出现错误：java.lang.OutOfMemoryErroe: Java heap space，因为所有Java对象的实例和数组都是在堆上分配内存的
}
