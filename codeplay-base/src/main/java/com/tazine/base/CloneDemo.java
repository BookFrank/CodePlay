package com.tazine.base;

/**
 * CloneDemo
 *
 * @author frank
 * @since 1.0.0
 */
public class CloneDemo {

    public static void main(String[] args) throws CloneNotSupportedException {

        Player kobe = new Player("kobe", 24);
        System.out.println("kobe : " + kobe.getName() + "-" + kobe.getNum());

        try {
            Player james = (Player) kobe.clone();
            james.setName("james");
            System.out.println("james : " + james.getName() + "-" + james.getNum());
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        Team team = new Team("Lakers");
        Player p1 = new Player("frank", 25, team);
        Player p2 = new Player("daniel", 5);
        Player p3 = p1;
        Player p4 = (Player) p1.clone();
        System.out.println(p1.toString());
        System.out.println(p2.toString());
        System.out.println(p3.toString());
        System.out.println(p4.toString());

        // 深拷贝 & 浅拷贝
        p1.setName("iverson");
        System.out.println("P4 : " + p4.getName() + " " + p4.getTeam().getName());
        p1.getTeam().setName("76ers");
        System.out.println("P1 : " + p1.getName() + " " + p1.getTeam().getName());
        System.out.println("P4 : " + p4.getName() + " " + p4.getTeam().getName());

        // p3 = p1 发生的是引用的复制，p4 是真实的创建对象
    }
}

class Player implements Cloneable {

    private String name;
    private int num;
    private Team team;

    public Player(String name, int num, Team team) {
        this.name = name;
        this.num = num;
        this.team = team;
    }

    public Player(String name, int num) {
        this.name = name;
        this.num = num;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
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

class Team {
    private String name;

    public Team(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
