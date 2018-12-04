package com.lyp.userconsumer.controller;

import com.lyp.userconsumer.pojo.User;
import com.lyp.userconsumer.service.UserConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>@filename UserConsumerController</p>
 * <p>
 * <p>@description TODO</p>
 *
 * @author liyupeng
 * @version 1.0
 * @since 2018/11/28 14:23
 **/
@RestController
@RequestMapping("/user-consumer")
public class UserConsumerController {

    @Autowired
    private UserConsumerService service;

    @GetMapping("/getUser")
    public User getUser(Long id){
        return this.service.getUser(id);
    }
}
