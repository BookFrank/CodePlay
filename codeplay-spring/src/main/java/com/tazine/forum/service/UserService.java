package com.tazine.forum.service;

import com.tazine.forum.dao.LoginLogDao;
import com.tazine.forum.dao.UserDao;
import com.tazine.forum.domain.LoginLog;
import com.tazine.forum.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by lina on 2017/10/9.
 */
@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private LoginLogDao loginLogDao;

    public boolean hasMatchUser(String username, String password){
        return userDao.getMatchCount(username, password) > 0;
    }

    public User findUserByUserName(String username){
        return userDao.findUserByUserName(username);
    }


    @Transactional
    public void loginSuccess(User user){
        user.setCredits(5 + user.getCredits());
        LoginLog loginLog = new LoginLog();
        loginLog.setUserId(user.getUserId());
        loginLog.setIp(user.getLaseIp());
        loginLog.setLoginDate(user.getLastVisit());
        userDao.updateLoginInfo(user);
        loginLogDao.insertLoginLog(loginLog);
    }



}
