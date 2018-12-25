package com.tazine.base.exception;

/**
 * Created by lina on 2017/12/27.
 *
 * @author frank
 * @date 2017/12/27
 */
public class ExceptCase {

    public static void main(String[] args) {
        //go();
        //System.out.println(System.getProperty("sun.boot.class.path"));
        //System.out.println(System.getProperty("java.class.path"));

        System.out.println(ExceptCase.class.getClassLoader());
        System.out.println(ExceptCase.class.getClassLoader().getParent());
        System.out.println(ExceptCase.class.getClassLoader().getParent().getParent());
    }

    private static void go(){
        if (1 == 1) {
            throw new WangException();
        }

    }

    public static class WangException extends RuntimeException{

    }

}
