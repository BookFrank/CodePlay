package com.tazine.codeplay.db.datasource.druid;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * DruidDataSourceHolder
 *
 * @author frank
 * @date 2017/3/13
 */
public class DruidDataSourceHolder {

    private static DruidDataSource dataSource;

    static {
        dataSource = new DruidDataSource();

        dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/test");
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUsername("root");
        dataSource.setPassword("jiaer.ly");
    }

    public static DruidPooledConnection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    public static void main(String[] args) throws SQLException {
        Connection con = getConnection();

        Statement st = con.createStatement();

        ResultSet rt = st.executeQuery("SELECT * FROM player");

        while (rt.next()) {
            System.out.println(rt.getString("name"));
        }
    }
}
