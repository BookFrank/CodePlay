package com.tazine.base;

/**
 * Created by lina on 2017/12/21.
 */
public class CloneDemo {

    public static void main(String[] args) {

        Player kobe = new Player("kobe", 24);
        System.out.println("kobe : " + kobe.getName() +"-" + kobe.getNum());

        try {
            Player james = (Player) kobe.clone();
            james.setName("james");
            System.out.println("james : " + james.getName() +"-" + james.getNum());
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

    }
}


class Player implements Cloneable{

    private String name;
    private int num;

    public Player(String name, int num) {
        this.name = name;
        this.num = num;
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

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
