package com.lyp.userservice1.controller;

import com.lyp.userservice1.pojo.User;
import com.lyp.userservice1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * <p>@filename UserController</p>
 * <p>
 * <p>@description TODO</p>
 *
 * @author liyupeng
 * @version 1.0
 * @since 2018/11/28 14:10
 **/
@RestController
@RequestMapping("/user-service")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/getUser")
    public User getUser(Long id) {
        int sleep = new Random().nextInt(2000);
        System.out.println("user-service1 get /user-service/getUser......");
        System.out.println("sleep : " + sleep);
        try {
            //方便测试hystrix熔断
            TimeUnit.MILLISECONDS.sleep(sleep);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this.userService.getById(id);
    }

}
