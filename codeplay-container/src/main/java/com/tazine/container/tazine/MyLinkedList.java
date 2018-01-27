package com.tazine.container.tazine;

import java.util.Iterator;

/**
 * 实现单链表
 *
 * @author frank
 * @since 1.0.0
 */
public class MyLinkedList<E> implements Iterable<E> {

    private Node<E> head;

    private int size;
    //private Node<E> root;

    public MyLinkedList() {
    }

    public boolean add(E element) {
        Node<E> node = new Node<>(element);
        if (null == head) {
            head = node;
        } else {
            Node foot = getLastNode();
            foot.next = node;
        }
        size++;
        return true;
    }

    public E get(int i) {
        if (i < size) {
            if (i == 0){
                return head.data;
            }
            Node<E> node = head;
            for (int j = 0; j < i; j++) {
                node = node.next;
            }
            return node.data;
        }
        return null;
    }

    public boolean remove(int index){
        if (index < 0 || index > size){
            return false;
        }
        return true;
    }

    private Node<E> getLastNode() {
        Node<E> node = head;
        while (head.next != null) {
            node = node.next;
        }
        return node;
    }

    /**
     * 为了正确地反转一个链表，需要调整指针的指向，一旦调整链表指向，链表有可能断开。
     * 为了避免链表断开，需要在调整 x 节点的 next 之前，把 next 指向的节点保存下来。
     * 接着试着找到反转后链表的头结点
     */
    private void flip(){
        Node<E> reverseHead = head;
        Node<E> currentNode = head;
        Node<E> prevNode = null;
        while (currentNode != null){
            Node<E> next = currentNode.next;
            if (next == null){
                reverseHead = currentNode;
            }
            currentNode.next = prevNode;
            prevNode = currentNode;
            currentNode = next;
        }
        this.head = reverseHead;
    }

    private void reversePrint(Node<E> node){
        if (node != null){
            reversePrint(node.next);
            System.out.print(node.data + " ");
        }
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    class Node<E> {
        E data;
        Node<E> next;

        public Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }

        public Node(E data) {
            this.data = data;
        }
    }


    public static void main(String[] args) {

        MyLinkedList<String> list = new MyLinkedList<>();

        list.add("kobe");
        list.add("james");

        System.out.println(list.get(0));
        System.out.println(list.get(1));

        //list.reversePrint(list.head);
        list.flip();
        System.out.println(list.get(0));
        System.out.println(list.get(1));
    }
}

