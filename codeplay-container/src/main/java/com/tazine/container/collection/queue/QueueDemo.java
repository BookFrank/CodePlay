package com.tazine.container.collection.queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 先进先出队列：使用 LinkedList 作为 Queue
 *
 * @author frank
 * @since 1.0.0
 */
public class QueueDemo {

    /**
     * LinkedList 提供了方法以支持队列的行为，并且它实现了Queue接口，因此LinkedList可以用作Queue的一种实现。
     * 通过将 LinkedList 向上转型为Queue
     */

    public static void main(String[] args) {
        Queue<Character> queue = new LinkedList<>();
        String str = "Hello World";

        for (char c : str.toCharArray()) {
            queue.offer(c);
        }
        printQueue(queue);
    }

    private static void printQueue(Queue queue) {
        while (queue.peek() != null) {
            System.out.print(queue.remove() + " ");
        }
        System.out.println();
    }
}
