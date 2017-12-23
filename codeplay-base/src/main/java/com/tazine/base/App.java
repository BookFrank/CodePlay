package com.tazine.base;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;

/**
 * Hello world!
 *
 */
public class App 
{

    private static int a = 1;

    private int ab = 2;

    public static void main( String[] args )
    {

        Hashtable<String,Integer> h = new Hashtable<String, Integer>();

        h.put("a",1);
        h.put("b",2);
        h.put("c",3);
        h.put("d",4);

//        Enumeration a = h.elements();
//        while (a.hasMoreElements()){
//            System.out.println(a.nextElement());
//        }

        App app = new App();
        System.out.println(app.ab);
        System.out.println(App.a);
    }
}
