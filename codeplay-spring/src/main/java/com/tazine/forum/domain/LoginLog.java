package com.tazine.forum.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by lina on 2017/10/9.
 *
 * @author frank
 * @date 2017/10/09
 */
public class LoginLog implements Serializable {

    private int LoginLogId;
    private int userId;
    private String ip;
    private Date loginDate;

    public int getLoginLogId() {
        return LoginLogId;
    }

    public void setLoginLogId(int loginLogId) {
        LoginLogId = loginLogId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Date getLoginDate() {
        return loginDate;
    }

    public void setLoginDate(Date loginDate) {
        this.loginDate = loginDate;
    }
}
