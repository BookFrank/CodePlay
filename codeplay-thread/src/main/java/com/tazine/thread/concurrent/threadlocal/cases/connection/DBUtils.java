package com.tazine.thread.concurrent.threadlocal.cases.connection;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * DBUtils
 *
 * @author frank
 * @since 1.0.0
 */
public class DBUtils {

    private static Connection conn = null;

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/demo", "root", "");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        return conn;
    }
}
