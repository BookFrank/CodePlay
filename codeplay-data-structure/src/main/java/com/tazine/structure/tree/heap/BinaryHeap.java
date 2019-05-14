package com.tazine.structure.tree.heap;

import java.util.Arrays;

/**
 * BinaryHeap
 *
 * @author frank
 * @date 2018/01/27
 */
public class BinaryHeap {

    private int[] heap;

    private int currentSize;

    public BinaryHeap(int[] items) {
        currentSize = items.length;
        heap = new int[(currentSize + 2) * 11 / 10];

        System.out.println((currentSize + 2) * 11 / 10);
        int i = 1;
        for (int item : items) {
            heap[i++] = item;
        }
        buildHeap();
    }

    private void buildHeap() {
        // i 表示的是非叶节点
        for (int i = currentSize / 2; i > 0; i--) {
            percolateDown(i);
        }
    }

    /**
     * 下滤算法
     *
     * @param i
     */
    private void percolateDown(int i) {
        int child;
        int tmp = heap[i];
        for (; i * 2 <= currentSize; i = child) {
            child = i * 2;
        }
    }

    public void print() {
        System.out.println(Arrays.toString(heap));
    }

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        BinaryHeap heap = new BinaryHeap(arr);
        heap.print();

    }
}
