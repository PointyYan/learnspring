package com.smart.service;

import com.smart.dao.LoginLogDao;
import com.smart.dao.UserDao;
import com.smart.domain.LoginLog;
import com.smart.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: VaporYan
 * @Decription:
 * @Date: Created in 15:36 2018/4/16
 * @Modified By:
 */
@Service
public class UserService {

    private UserDao userDao;
    private LoginLogDao loginLogDao;


//    public UserDao getUserDao() {
//        return userDao;
//    }
    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

//    public LoginLogDao getLoginLogDao() {
//        return loginLogDao;
//    }

    @Autowired
    public void setLoginLogDao(LoginLogDao loginLogDao) {
        this.loginLogDao = loginLogDao;
    }

    //检查用户名、密码的正确性
    public boolean hasMatchUser(String userName, String password) {
        int matchCount = userDao.getMatchCount(userName, password);
        return matchCount > 0;
    }

    //以用户名为条件加载User对象
    public User findUserByUserName(String userName) {
        return userDao.findUserByUserName(userName);
    }

    @Transactional
    public void loginSuccess(User user) {
        user.setCredits(5 + user.getCredits());
        LoginLog loginLog = new LoginLog();
        loginLog.setUserId(user.getUserId());
        loginLog.setIp(user.getLastIp());
        loginLog.setLoginDate(user.getLastVisit());
        userDao.updateLoginInfo(user);
        loginLogDao.insertLoginLog(loginLog);
    }

}
