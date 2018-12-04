package com.lyp.consumer.service;

import com.lyp.consumer.pojo.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

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

    @Autowired
    private DiscoveryClient discoveryClient;

    /**
     * getUser
     *
     * @param id
     * @param num 模拟随机调用USER-SERVICE的不同实例 （参数值只能为0，1）
     * @return
     */
    public User getUser(Long id, Integer num){
        String serviceName = "USER-SERVICE";
        List<ServiceInstance> instances = this.discoveryClient.getInstances(serviceName);
        System.out.println(instances.size());
        ServiceInstance serviceInstance = instances.get(num);
        System.out.println(serviceInstance.getHost());
        String url = serviceInstance.getUri()+"/"+serviceInstance.getServiceId().toLowerCase()+"/getUser"+"?id=" + id;
        System.out.println(url);
        return restTemplate.getForObject(url,User.class);
    }

    /**
     * getUser1  @LoadBalanced（使用Ribbon负载均衡）
     *
     * @param id
     * @return
     */
    public User getUser1(Long id){
        String url = "http://user-service/user-service/getUser?id=" + id;
        return restTemplate.getForObject(url,User.class);
    }

    @HystrixCommand(fallbackMethod = "getUserByIdFallback")
    public User getUserById(Long id){
        String url = "http://user-service/user-service/getUser?id=" + id;
        Long start = System.currentTimeMillis();
        User user = restTemplate.getForObject(url,User.class);
        Long end = System.currentTimeMillis();
        System.out.println("getUserById duration : " + (end - start));
        return user;
    }

    private User getUserByIdFallback(Long id) {
        System.out.println("getUser2方法异常，超时熔断!");
        User user = new User();
        user.setName("数据获取异常");
        return user;
    }


}
