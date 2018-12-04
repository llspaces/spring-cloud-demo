package com.lyp.feignconsumer.service;

import com.lyp.feignconsumer.dao.UserFeignClient;
import com.lyp.feignconsumer.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>@filename FeignConsumerService</p>
 * <p>
 * <p>@description TODO</p>
 *
 * @author liyupeng
 * @version 1.0
 * @since 2018/11/28 14:21
 **/
@Service
public class FeignConsumerService {

    @Autowired
    private UserFeignClient userFeignClient;

    public List<User> getUsers(@RequestParam("ids") List<Long> ids){
        List<User> users = new ArrayList<>();
        for(Long id : ids){
            Long start = System.currentTimeMillis();
            users.add( userFeignClient.getUser(id));
            Long end = System.currentTimeMillis();
            System.out.println("userFeignClient.getUser duration : " + (end - start));
        }
        return users;
    }


}
