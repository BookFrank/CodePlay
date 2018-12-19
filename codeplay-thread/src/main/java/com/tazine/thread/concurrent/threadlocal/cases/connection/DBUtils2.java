package com.tazine.thread.concurrent.threadlocal.cases.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * DBUtils2
 *
 * @author frank
 * @date 2017/12/27
 */
public class DBUtils2 {

    private static ThreadLocal<Connection> connContainer = new ThreadLocal<>();

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        Connection conn = connContainer.get();
        if (conn == null) {
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/demo", "root", "");
            connContainer.set(conn);
        }
        return conn;
    }

}
