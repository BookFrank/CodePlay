package com.tazine.structure.list;


import java.util.Stack;

/**
 * LinkedList 实现
 *
 * @author frank
 * @date 2017/12/22
 */
public class MyLinkedList<T> {

    private Node<T> head = null;
    private Node<T> tail = null;

    /**
     * 添加元素
     *
     * @param data
     */
    public void add(T data) {
        Node<T> node = new Node<>(data);
        if (null == head || null == head.data) {
            head = node;
        } else {
            tail.next = node;
        }
        tail = node;
    }

    /**
     * 删除元素
     *
     * @param data
     */
    public void remove(T data) {
        Node<T> upperNode = null;
        Node<T> subNode = null;
        Node<T> node = head;
        while (null != node) {
            if (node != tail && node.next.data == data) {
                upperNode = node;
                // 如果当前节点不为尾节点
                if (node.next != tail) {
                    subNode = node.next.next;
                } else {
                    break;
                }
            }

            if (null != upperNode && null != subNode) {
                break;
            }
            node = node.next;
        }
        if (null == upperNode) {
            return;
        }
        // 后继节点为空，说明该节点是尾节点
        if (null == subNode) {
            upperNode.next.data = null;
            upperNode.next.next = null;
            upperNode.next = null;
            tail = upperNode;
        } else {
            upperNode.next.data = null;
            upperNode.next.next = null;
            upperNode.next = subNode;
        }
    }

    /**
     * 根据编号获取元素
     *
     * @param i
     * @return
     */
    public T get(int i) {
        Node<T> node = indexOf(i);
        return node.data;
    }

    public int size() {
        int size = 0;
        Node<T> node = head;
        while (node != null) {
            size++;
            node = node.next;
        }
        return size;
    }

    public boolean contains(T data) {
        return null != indexOf(data);
    }

    public void clear() {
        Node<T> node = head;
        while (null != node) {
            Node<T> thisNode = node;
            node = node.next;
            thisNode.data = null;
            thisNode.next = null;
        }
        head = tail = null;
    }

    public void printList() {
        Node<T> node = head;
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    public void debug() {
        Node<T> node = head;
        while (node != null) {
            System.out.print(node.data + " " + node.next + "  ");
            node = node.next;
        }
        System.out.println();
    }

    private Node<T> indexOf(int i) {
        Node<T> node = head;
        while (i-- > 0) {
            node = node.next;
        }
        return node;
    }

    private Node<T> indexOf(T data) {
        Node<T> node = head;
        while (null != node) {
            if (node.data == data) {
                return node;
            } else {
                node = node.next;
            }
        }
        return null;
    }

    /**
     * 如何实现链表的反转
     */
    public void reverse() {
        Node<T> node = head;
        Node<T> tmp = null; // 用来保存上一个节点，让当前的node.next指向
        Node<T> whileTemp = null; // 用来保存下一个节点,维持循环
        while (node != null) {
            whileTemp = node.next;
            node.next = tmp;
            tmp = node;
            node = whileTemp;
        }
    }

    /**
     * 如何从尾到头输出单链表：利用栈
     */
    public void reversePrint() {
        Stack<T> stack = new Stack<>();
        Node<T> node = head;
        while (node != null) {
            stack.push(node.data);
            node = node.next;
        }
        while (!stack.empty()) {
            System.out.print(stack.pop() + " ");
        }
        System.out.println();
    }

    /**
     * 如何从尾到头输出单链表：递归，本质上也是一个栈。
     */
    public void reversePrint1(Node<T> node) {
        if (node != null) {
            reversePrint1(node.next);
            System.out.print(node.data + " ");
        }
    }

    public Node<T> getHead() {
        return head;
    }

    public Node<T> getTail() {
        return tail;
    }
}
