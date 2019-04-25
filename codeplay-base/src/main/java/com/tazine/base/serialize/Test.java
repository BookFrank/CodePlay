package com.tazine.base.serialize;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Test
 *
 * @author frank
 * @date 2019/04/25
 */
public class Test {

    public static void main(String[] args) throws Exception {

        Player p = new Player();
        p.setName("kobe");
        p.setNum(24);
        p.setTeam("lakers");

        //FileOutputStream fileOut = new FileOutputStream("/Users/jiaer.ly/Desktop/e.ser");
        //ObjectOutputStream out = new ObjectOutputStream(fileOut);
        //out.writeObject(p);
        //out.close();
        //fileOut.close();

        Player e = null;
        FileInputStream fileIn = new FileInputStream("/Users/jiaer.ly/Desktop/e.ser");
        ObjectInputStream in = new ObjectInputStream(fileIn);
        e = (Player)in.readObject();
        in.close();
        fileIn.close();

        System.out.println(e.getName());
        System.out.println(e.getNum());
        System.out.println(e.getTeam());
    }
}
