package com.smart.web;

/**
 * @Author: VaporYan
 * @Decription:
 * @Date: Created in 17:34 2018/4/17
 * @Modified By:
 */

public class LoginCommand {
    private String userName;

    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
