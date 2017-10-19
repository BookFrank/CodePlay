package com.tazine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Hello world!
 *
 */
public class App
{


    public static void main( String[] args )
    {

        MyThread thread = new MyThread();

        thread.start();

        System.out.println( "Hello World!" );
    }
}
