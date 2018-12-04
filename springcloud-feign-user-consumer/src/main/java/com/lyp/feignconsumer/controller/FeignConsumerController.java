package com.lyp.feignconsumer.controller;

import com.lyp.feignconsumer.pojo.User;
import com.lyp.feignconsumer.service.FeignConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

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
@RequestMapping("/feign-consumer")
public class FeignConsumerController {

    @Autowired
    private FeignConsumerService feignConsumerService;

    @GetMapping("getUsers")
    public List<User> getUsers(@RequestParam("ids") List<Long> ids){
        return feignConsumerService.getUsers(ids);
    }
}
