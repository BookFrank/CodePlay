package com.tazine.container.utils;

import java.util.Comparator;

/**
 * 实现Comparable接口的Bean
 *
 * @author frank
 * @since 1.0.0
 */
public class NbaPlayer implements Comparable<NbaPlayer> {

    private String name;
    private int number;

    public NbaPlayer(String name, int number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public int compareTo(NbaPlayer o) {
        int diff = this.number - o.number;
        return diff == 0 ? this.name.compareTo(o.name) : diff;
    }

    @Override
    public String toString() {
        return this.name + ":" + this.number;
    }
}

class PlayerComparator implements Comparator<NbaPlayer>{

    @Override
    public int compare(NbaPlayer o1, NbaPlayer o2) {
        int diff = o1.getNumber() - o2.getNumber();
        return diff == 0 ? o1.getName().compareTo(o1.getName()) : diff;
    }
}