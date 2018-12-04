package com.lyp.userservice.controller;

import com.lyp.userservice.pojo.User;
import com.lyp.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        System.out.println("Get /user-service/getUser......");
        return this.userService.getById(id);
    }

}
