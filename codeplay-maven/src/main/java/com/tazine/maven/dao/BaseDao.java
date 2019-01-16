package com.tazine.maven.dao;

import java.sql.*;

/**
 * BaseDao - Connect db and query one row
 *
 * @author frank
 * @date 2018/12/11
 */
public class BaseDao {

    public static void main(String[] args) throws SQLException {

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/demo", "root", "");

        Statement st = conn.createStatement();

        ResultSet rt = st.executeQuery("SELECT * FROM customer");

        while (rt.next()) {
            System.out.println(rt.getString("name"));
        }

    }
}
