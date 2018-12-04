package com.lyp.userconsumer.service;

import com.lyp.userconsumer.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * <p>@filename ConsumerService</p>
 * <p>
 * <p>@description TODO</p>
 *
 * @author liyupeng
 * @version 1.0
 * @since 2018/11/28 14:21
 **/
@Service
public class UserConsumerService {
    @Autowired
    private RestTemplate restTemplate;

    public User getUser(Long id){
        String url = "http://localhost/user-service/getUser?id=" + id;
        return restTemplate.getForObject(url,User.class);
    }
}
