package com.tazine.third.protostuff;

/**
 * NbaPlayer
 *
 * @author frank
 * @date 2018/03/01
 */
public class NbaPlayer {

    public NbaPlayer() {
    }

    private String name;

    private String team;

    private int num;

    private int height;

    public NbaPlayer(String name, String team, int num, int height) {
        this.name = name;
        this.team = team;
        this.num = num;
        this.height = height;
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

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "NbaPlayer{" +
                "name='" + name + '\'' +
                ", team='" + team + '\'' +
                ", num=" + num +
                ", height=" + height +
                '}';
    }
}
