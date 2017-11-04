package com.tazine.basic;

/**
 * Created by ly on 2017/9/11.
 * 一个.java文件可以包含多个类（非内部类），但是只能有一个类是public修饰
 */
public class Lec1 {

    public static void main(String[] args) {

        Player kobe = new Player("kobe");

        System.out.println(kobe.getName());
        System.out.println(kobe.getNum());

    }

}

class Player{

    private String name;

    private int num;

    public Player(String name, int num) {
        this.name = name;
        this.num = num;
    }

    // int的默认值是0  Integer的默认值是null
    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
