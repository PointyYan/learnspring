package com.smart.conf;

/**
 * @Author: VaporYan
 * @Decription:
 * @Date: Created in 13:23 2018/4/20
 * @Modified By:
 */
public class LogonService {
    private LogDao logDao;
    private UserDao userDao;
    public LogDao getLogDao() {
        return logDao;
    }
    public void setLogDao(LogDao logDao) {
        this.logDao = logDao;
    }
    public UserDao getUserDao() {
        return userDao;
    }
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void printHelllo(){
        System.out.println("hello!");
    }

}
