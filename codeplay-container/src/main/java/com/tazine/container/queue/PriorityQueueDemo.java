package com.tazine.container.queue;

import java.util.*;

/**
 * 优先级队列：下一个弹出元素是最需要的元素（具有最高的优先级）
 *
 * @author frank
 * @since 1.0.0
 */
public class PriorityQueueDemo {

    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        Random rand = new Random(47);
        for (int i = 0; i < 10; i++) {
            int r = rand.nextInt();
            priorityQueue.offer(r);
        }
        printQueue(priorityQueue);

        List<Integer> ints = Arrays.asList(9, 1, 2, 3, 4, 5, 6, 7, 10, 9);
        PriorityQueue<Integer> integerPriorityQueue = new PriorityQueue<>(ints);
        printQueue(integerPriorityQueue);
        PriorityQueue<Integer> integerPriorityQueue1 = new PriorityQueue<Integer>(ints.size(), Collections.reverseOrder());
        integerPriorityQueue1.addAll(ints);
        printQueue(integerPriorityQueue1);


        // 利用 Set 来去重
        String s = "hello world";
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            set.add(c);
        }
        PriorityQueue<Character> charQueue = new PriorityQueue<>(set);
        printQueue(charQueue);
    }

    private static void printQueue(Queue queue) {
        while (queue.peek() != null) {
            System.out.print(queue.remove() + " ");
        }
        System.out.println();
    }
}
