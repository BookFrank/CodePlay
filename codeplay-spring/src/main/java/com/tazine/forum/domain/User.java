package com.tazine.forum.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * User
 *
 * @author frank
 * @date 2017/10/09
 */
public class User implements Serializable {

    private int userId;
    private String userName;
    private String password;
    private int credits;
    private String laseIp;
    private Date lastVisit;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public String getLaseIp() {
        return laseIp;
    }

    public void setLaseIp(String laseIp) {
        this.laseIp = laseIp;
    }

    public Date getLastVisit() {
        return lastVisit;
    }

    public void setLastVisit(Date lastVisit) {
        this.lastVisit = lastVisit;
    }
}
