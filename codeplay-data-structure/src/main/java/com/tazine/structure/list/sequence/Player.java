package com.tazine.structure.list.sequence;

/**
 * 需要保存在顺序表中的元素
 *
 * @author frank
 * @date 2018/01/19
 */
public class Player {

    private String name;
    private String team;
    private int num;

    public Player(String name, String team, int num) {
        this.name = name;
        this.team = team;
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", team='" + team + '\'' +
                ", num=" + num +
                '}';
    }
}
