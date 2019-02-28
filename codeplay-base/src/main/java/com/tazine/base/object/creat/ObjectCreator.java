package com.tazine.base.object.creat;

import com.alibaba.fastjson.JSON;
import com.tazine.base.Player;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.lang.reflect.Constructor;

/**
 * 创建对象的方式
 *
 * @author frank
 * @date 2018/12/30
 */
public class ObjectCreator {

    public static void main(String[] args) throws Exception {

        // 1. 使用new关键字，调用了构造函数
        Player player = new Player("kobe", 24);
        System.out.println(player);

        // 2. 使用Class类的newInstance方法
        Player player1 = (Player)Class.forName("com.tazine.base.Player").newInstance();
        player1.setName("james");
        player1.setNum(23);
        System.out.println(player1);

        // 3. 使用Constructor类的newInstance方法
        // 和Class类的newInstance方法很像， java.lang.reflect.Constructor类里也有一个newInstance方法可以创建对象。我们可以通过这个newInstance方法调用有参数的和私有的构造函数
        Constructor<Player> constructor = Player.class.getConstructor();
        Player player2 = constructor.newInstance();
        player2.setNum(3);
        System.out.println(player2);

        // 4. 使用clone，与前面不同的是不会调用任何构造函数
        Player player3 = (Player)player.clone();
        System.out.println(player3);

        // 5. 使用序列化，不会调用构造函数
        // 当我们序列化和反序列化一个对象，jvm会给我们创建一个单独的对象。在反序列化时，jvm创建对象并不会调用任何构造函数。
        // 为了反序列化一个对象，我们需要让我们的类实现Serializable接口
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("data.obj"));
        Player player4 = (Player)in.readObject();
        String json = JSON.toJSONString(player);
        Player player5 = JSON.parseObject(json, Player.class);
        System.out.println("json: " + player5 + " - " + (player == player5));
    }
}
