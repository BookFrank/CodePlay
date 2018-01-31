package com.tazine.container.collection.set;

import java.util.HashSet;
import java.util.Set;

/**
 * HashSet 去重原理：根据对象的 equals() 和 hashcode()
 *
 * @author frank
 * @since 1.0.0
 */
public class SetPractice {

    public static void main(String[] args) {

        Integer a = new Integer(10);
        Integer b = new Integer(10);


        Set<Integer> set = new HashSet<>();

        set.add(a);
        set.add(b);

        // 包装类型比较应该使用 equals 而不是 ==
        System.out.println(a == b);
        for (Integer i : set) {
            System.out.println(i);
        }
        System.out.println(set.size());


        Player p1 = new Player("kobe");
        Player p2 = new Player("james");

        Set<Player> playerSet = new HashSet<>();
        playerSet.add(p1);
        playerSet.add(p2);


        System.out.println(p1.equals(p2));
        for (Player p : playerSet) {
            System.out.println(p.getName());
        }


    }

}

class Player {

    private String name;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * 重写Object类的equals方法，直接返回 true
     *
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        return true;
    }

    @Override
    public int hashCode() {
        return 1;
    }
}
