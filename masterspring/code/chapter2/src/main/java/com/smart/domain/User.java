package com.smart.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: VaporYan
 * @Decription:
 * @Date: Created in 14:40 2018/4/16
 * @Modified By:
 */

//领域对象一般要实现Serializable，以便可以实现序列化
public class User implements Serializable{

    private int userId;
    private String userName;
    private String passWord;
    private int credits;
    private String lastIp;
    private Date lastVisit;

    public int getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public int getCredits() {
        return credits;
    }

    public String getLastIp() {
        return lastIp;
    }

    public Date getLastVisit() {
        return lastVisit;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public void setLastIp(String lastIp) {
        this.lastIp = lastIp;
    }

    public void setLastVisit(Date lastVisit) {
        this.lastVisit = lastVisit;
    }




}
