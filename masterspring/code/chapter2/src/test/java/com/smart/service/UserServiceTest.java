package com.smart.service;

import com.smart.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.annotations.Test;

import java.util.Date;

import static org.testng.Assert.*;

/**
 * @Author: VaporYan
 * @Decription:
 * @Date: Created in 15:53 2018/4/16
 * @Modified By:
 */

@ContextConfiguration("classpath*:/smart-context.xml") //启动spring容器
public class UserServiceTest extends AbstractTransactionalTestNGSpringContextTests {

    private UserService userService;

    @Autowired //注入bean
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Test
    public void hasMatchUser() {
        boolean b1 = userService.hasMatchUser("admin", "123456");
        boolean b2 = userService.hasMatchUser("admin", "111");
        assertTrue(b1);
        assertTrue(!b2);
    }

    @Test
    public void testFindUserByUserName()throws Exception{
        for(int i =0; i< 100;i++) {
            User user = userService.findUserByUserName("admin");
            assertEquals(user.getUserName(), "admin");
        }

    }

    @Test
    public void testAddLoginLog() {
        User user = userService.findUserByUserName("admin");
        user.setUserId(1);
        user.setUserName("admin");
        user.setLastIp("192.168.12.7");
        user.setLastVisit(new Date());
        userService.loginSuccess(user);
    }
}

