package com.tazine.forum.dao;

import com.tazine.forum.domain.LoginLog;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * Created by lina on 2017/10/9.
 *
 * @author frank
 * @date 2017/10/09
 */
@Repository
public class LoginLogDao {

    private JdbcTemplate jdbcTemplate;

    private final static String INSERT_LOGIN_LOG_SQL = " INSERT INTO t_login_log(user_id,ip,login_datetime) VALUES(?,?,?) ";

    public void insertLoginLog(LoginLog loginLog){
        Object[] args = {loginLog.getUserId(), loginLog.getIp(), loginLog.getLoginDate()};
        jdbcTemplate.update(INSERT_LOGIN_LOG_SQL, args);
    }




}
