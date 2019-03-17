package com.tazine.codeplay.db.spring;

import com.alibaba.druid.pool.DruidDataSource;
import com.tazine.codeplay.db.NbaPlayer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

/**
 * Spring-Jdbc 的使用
 *
 * @author frank
 * @date 2019/03/14
 */
@Configuration
public class SpringJdbcDemo {

    @Bean
    public DataSource dataSource() {
        DruidDataSource dataSource = new DruidDataSource();

        dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/test");
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUsername("root");
        dataSource.setPassword("jiaer.ly");
        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(dataSource());
    }

    public static void main(String[] args) throws Exception {

        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringJdbcDemo.class);

        for (String s : ctx.getBeanDefinitionNames()) {
            System.out.println(s + " - " + ctx.getBean(s).getClass());
        }

        // 1. Spring 使用 dataSource 查询
        DataSource dataSource = (DataSource)ctx.getBean("dataSource");
        Connection con = dataSource.getConnection();
        Statement st = con.createStatement();
        ResultSet rt = st.executeQuery("SELECT * FROM player");
        while (rt.next()) {
            System.out.println(rt.getString("name"));
        }
        st.close();
        con.close();
        System.out.println("====================");

        // 2. Spring-Jdbc 使用 JDBCTemplate 进行查询
        JdbcTemplate jdbcTemplate = (JdbcTemplate)ctx.getBean("jdbcTemplate");
        List<NbaPlayer> players = jdbcTemplate.query("SELECT * FROM player", new PlayerRowMapper());
        players.forEach(p -> {
            System.out.println(p.getName() + " - " + p.getTeam());
        });
    }
}
