package com.tazine.container.collection.list;

/**
 * MyLinkedList
 *
 * @author frank
 * @since 1.0.0
 */
public class MyLinkedList<E> {

    private Node<E> head;

    private int size;

    public MyLinkedList() {
    }

    public void add(E element){
        Node<E> node = new Node<>(element);
        if (null == head){
            head = node;
            size++;
            return;
        }
        Node<E> tmpNode = head;
        while (tmpNode.next != null){
            tmpNode = tmpNode.next;
        }
        tmpNode.next = node;
        size++;
    }

    public E get(int index){
        rangeCheck(index);
        Node<E> node = head;
        while (index-- > 0){
            node = node.next;
        }
        return node.data;
    }

    private void rangeCheck(int index) {
        if (index >= size){
            throw new IndexOutOfBoundsException("out of bounds");
        }
    }

    public void print(){
        if (head != null){
            Node<E> node = head;
            while (node != null){
                System.out.print(node.data + " ");
                node = node.next;
            }
        }
        System.out.println();
    }

    public void reversePrint(Node<E> node){
        if (node != null){
            reversePrint(node.next);
            System.out.print(node.data + " - ");
        }
    }

    public void flip(){
        Node<E> reverseHead = null;
        Node<E> currentNode = head;
        Node<E> prevNode = null;
        while (currentNode != null){
            Node<E> nextNode = currentNode.next;
            if (nextNode == null){
                reverseHead = currentNode;
            }
            currentNode.next = prevNode;
            prevNode = currentNode;
            currentNode = nextNode;
        }
        head = reverseHead;
    }

    private static class Node<E> {
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
        list.print();
        list.add("james");
        list.add("iverson");
        list.print();
        System.out.println();
        System.out.println(list.get(0) + " -- " + list.get(1));
        list.reversePrint(list.head);
        System.out.println();
        list.flip();
        list.print();
    }
}
