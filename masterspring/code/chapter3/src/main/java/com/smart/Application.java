package com.smart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @Author: VaporYan
 * @Decription:
 * @Date: Created in 17:24 2018/4/17
 * @Modified By:
 */
@SpringBootApplication
@EnableTransactionManagement
public class Application extends SpringBootServletInitializer{
    //SpringBootServletInitializer。继承了Spring Boot提供的Servlet初始化器。

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(Application.class);
    }
}
