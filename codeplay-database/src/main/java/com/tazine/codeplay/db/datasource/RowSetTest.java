package com.tazine.codeplay.db.datasource;

import com.sun.rowset.JdbcRowSetImpl;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 * javax.sql.RowSet 使用
 *
 * @author frank
 * @date 2017/03/14
 */
public class RowSetTest {

    public static void main(String[] args) {
        beforeJava7();

        afterJava7();
    }

    private static void beforeJava7() {
        //java7前的使用方法，是不是看起来简单很多~
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/test", "root", "jiaer.ly");
            //传递一个con给JdbcRowSet构造器就可以啦
            JdbcRowSet jrs = new JdbcRowSetImpl(con);
            Class.forName("com.mysql.jdbc.Driver");

            jrs.setCommand("select * from player");
            jrs.execute();
            while (jrs.next()) {
                System.out.println(jrs.getString(1) + "\t" + jrs.getString(2) + "\t" + jrs.getString(3));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("=======================");
    }

    private static void afterJava7() {
        //java7开始 提供了RowSetFactory接口来生成各种RowSet
        try {
            // 先使用RowSetProvider创建一个RowSetFactory
            RowSetFactory rsf = RowSetProvider.newFactory();

            JdbcRowSet jrs = rsf.createJdbcRowSet();

            jrs.setUrl("jdbc:mysql://localhost/test");
            jrs.setUsername("root");
            jrs.setPassword("jiaer.ly");
            jrs.setCommand("select * from player");
            jrs.execute();
            while (jrs.next()) {
                System.out.println(jrs.getString(1) + "\t" + jrs.getString(2) + "\t" + jrs.getString(3));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("=======================");

        //是不是更简单了呢？我认为还是极好的~ 至少我只知道一个JdbcRowSet就可以进行数据库操作了，不像原来要创建各种对象
        //如果RowSet没有提供一个con的话，那么他将使用RowSetReader来完成execute方法
    }
}
