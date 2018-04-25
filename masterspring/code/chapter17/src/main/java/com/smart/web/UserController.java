package com.smart.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: VaporYan
 * @Decription:
 * @Date: Created in 15:33 2018/4/23
 * @Modified By:
 */
@Controller
@RequestMapping("/user")  //处理来自/user的请求
public class UserController {
    @RequestMapping("/register")
    public String register() {
        return "user/register";
    }
}
