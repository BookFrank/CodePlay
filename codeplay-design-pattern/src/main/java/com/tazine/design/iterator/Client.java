package com.tazine.design.iterator;

/**
 * Test
 *
 * @author frank
 * @since 1.0.0
 */
public class Client {

    public static void main(String[] args) {

        Container names = new NameContainer();
        Container nums = new NumberContainer();

        Iterator<String> it = names.getIterator();
        while (it.hasNext()){
            System.out.print(it.next() + " ");
        }
        System.out.println();

        Iterator<Integer> it1 = nums.getIterator();
        while (it1.hasNext()){
            System.out.print(it1.next() + " ");
        }
    }

}
