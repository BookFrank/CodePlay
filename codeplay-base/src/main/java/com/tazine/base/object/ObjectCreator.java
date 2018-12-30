package com.tazine.base.object;

import com.tazine.base.Player;

/**
 * 创建对象的方式
 *
 * @author jiaer.ly
 * @date 2018/12/30
 */
public class ObjectCreator {

    public static void main(String[] args) throws Exception {

        // 1. 使用new关键字，调用了构造函数
        Player player = new Player("kobe", 24);
        System.out.println(player);

        // 2. 使用Class类的newInstance方法
        Player player1 = (Player)Class.forName("com.tazine.base.Player").newInstance();
        player1.setName("jame");
        player1.setNum(23);
        System.out.println(player1);

        // 3. 使用Constructor类的newInstance方法
        // 和Class类的newInstance方法很像， java.lang.reflect.Constructor类里也有一个newInstance方法可以创建对象。我们可以通过这个newInstance方法调用有参数的和私有的构造函数
    }

}
