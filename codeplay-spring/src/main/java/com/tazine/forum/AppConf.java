package com.tazine.forum;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * Created by lina on 2017/10/9.
 *
 * @author frank
 * @date 2017/10/09
 */
@Configuration
@ComponentScan(basePackages = "com.tazine")
public class AppConf {

    @Bean
    public DataSource dataSource(){
        BasicDataSource ds = new BasicDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://127.0.0.1:3306/forum?useUnicode=true&characterEncoding=UTF-8");
        ds.setUsername("root");
        ds.setPassword("");
        return ds;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(){
        return new JdbcTemplate(dataSource());
    }


}
