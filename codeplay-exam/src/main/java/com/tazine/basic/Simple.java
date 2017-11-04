package com.tazine.basic;

/**
 * Created by lina on 2017/9/11.
 */
public class Simple {

    private final StringBuffer sb = new StringBuffer("YC");

    /**
     * 使用final修饰一个变量时，是指引用地址不能变，地址所指向的对象的内容是可以改变的
     */
    private void finalTest(){
        this.sb.append("----ly");
        Simple simple = new Simple();
        // this.sb = new StringBuffer();
        // 将报告编译失败,因为引用地址不可变
        System.out.println(this.sb.toString());
    }

    /**
     * "==" 和 equals 方法的区别
     * == 可以用来比较两个基本类型的数据或者两个引用变量是否相等
     * equals 用于比较两个独立对象的内容是否相同
     */
    private void equalTest(){

    }

    private void intTest(){



    }



    public static void main(String[] args) {
         Simple simple = new Simple();
         simple.finalTest();
//        System.out.println(a);
//        System.out.println(b);
    }




}
