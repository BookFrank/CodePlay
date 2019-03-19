package com.tazine.forum.dao;

import com.tazine.forum.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * UserDao
 *
 * @author frank
 * @date 2017/10/09
 */
@Repository
public class UserDao {

    @Autowired
    protected JdbcTemplate jdbcTemplate;

    private final static String MATCH_COUNT_SQL = " SELECT count(*) FROM t_user WHERE user_name =? and password =? ";

    private final static String USER_MATCH_SQL = " SELECT * FROM t_user WHERE user_name =?";

    private final static String UPDATE_LOGIN_INFO_SQL = " UPDATE t_user SET last_visit=?,last_ip=?,credits=? WHERE user_id =? ";


    public int getMatchCount(String userName, String password){
        return jdbcTemplate.queryForObject(MATCH_COUNT_SQL, Integer.class);
    }

    public User findUserByUserName(final String userName){
        final User user = new User();
        jdbcTemplate.query(USER_MATCH_SQL, new Object[]{userName},
                new RowCallbackHandler() {
                    public void processRow(ResultSet resultSet) throws SQLException {
                        user.setUserId(resultSet.getInt("user_id"));
                        user.setUserName(userName);
                        user.setCredits(resultSet.getInt("credits"));
                }
        });
        System.out.println(user.getUserName() + user.getUserId());
        return user;
    }

    public void updateLoginInfo(User user){
        jdbcTemplate.update(UPDATE_LOGIN_INFO_SQL, new Object[]{user.getLastVisit(), user.getLaseIp(),user.getCredits(),user.getUserId()});
    }

    public void diTest(){
        System.out.println("测试有没有DI");
    }

}
