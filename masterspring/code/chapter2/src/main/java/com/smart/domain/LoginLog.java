package com.smart.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: VaporYan
 * @Decription:
 * @Date: Created in 14:46 2018/4/16
 * @Modified By:
 */
public class LoginLog implements Serializable{
    public int getLoginLogId() {
        return loginLogId;
    }

    public void setLoginLogId(int loginLogId) {
        this.loginLogId = loginLogId;
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

    private int loginLogId;
    private int userId;
    private String ip;
    private Date loginDate;
}
