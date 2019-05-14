package com.tazine.structure.list;

/**
 * ListTest
 *
 * @author frank
 * @date 2017/12/22
 */
public class ListTest {

    public static void main(String[] args) {
        MyLinkedList<Integer> list = new MyLinkedList<>();

//        list.add(10);
//        list.add(24);
//        System.out.println(list.contains(24));
//        list.printList();
//        list.clear();
//        list.printList();
//
//        System.out.println(list.head);
//        System.out.println(list.head.data);
//        System.out.println(list.head.next);
//        System.out.println(list.tail);
//        System.out.println(list.tail.data);
//        System.out.println(list.tail.next);

        System.out.println();
        // contains() 中需增加 equals 来兼容包装类
        Integer a = new Integer(10);
        Integer b = new Integer(24);
        Integer c = new Integer(8);
        list.add(a);
        list.add(b);
        list.add(c);
        //System.out.println(list.contains(c));

        System.out.println(list.size());
        list.printList();
        //list.clear();
        //list.remove(b);
        //list.reverse();
        list.reversePrint();

        list.reversePrint1(list.getHead());

//        list.printList();
        //list.debug();


//        System.out.println(list.head.data);
//        System.out.println(list.head.next);
//        System.out.println(list.tail);
//        System.out.println(list.tail.data);
//        System.out.println(list.tail.next);
//
//        System.out.println(list.get(0));
//        System.out.println(list.get(1));
//        System.out.println(list.get(2));

    }

}
