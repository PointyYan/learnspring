package com.smart.proxy;

import org.testng.annotations.Test;

import java.lang.reflect.Proxy;

/**
 * @Author: VaporYan
 * @Decription:
 * @Date: Created in 15:27 2018/4/20
 * @Modified By:
 */
public class TestForumService {
    @Test
    public void proxy() {
//        ForumService forumService = new ForumServiceImpl();
//        forumService.removeForum(10);
//        forumService.removeTopic(1012);


        // 使用JDK动态代理
//        ForumService target = new ForumServiceImpl();
//        PerformaceHandler handler = new PerformaceHandler(target);
//        ForumService proxy = (ForumService) Proxy.newProxyInstance(target
//                        .getClass().getClassLoader(),
//                target.getClass().getInterfaces(), handler);
//        proxy.removeForum(10);
//        proxy.removeTopic(1012);

        //使用CGLib动态代理
        CglibProxy cglibProxy = new CglibProxy();
        ForumService forumService = (ForumService)cglibProxy.getProxy(ForumServiceImpl.class);
        forumService.removeForum(10);
        forumService.removeTopic(1023);
    }
}
