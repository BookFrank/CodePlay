package com.tazine.codeplay.db.raw;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * 使用 mysql 驱动连接 MySQL数据库
 *
 * @author frank
 * @date 2017/03/13
 */
public class App {

    public static void main(String[] args) {

        try {
            Class.forName("com.mysql.jdbc.Driver");

            Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", "root", "");

            Statement st = connection.createStatement();

            ResultSet rt = st.executeQuery("SELECT * FROM player");

            while (rt.next()) {
                System.out.println(rt.getString("name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
