package com.lyp.consumer.controller;

import com.lyp.consumer.pojo.User;
import com.lyp.consumer.service.UserConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
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
@RequestMapping("/user-consumer")
public class UserConsumerController {

    @Autowired
    private UserConsumerService service;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    /**
     * getUser
     *
     * @param id
     * @param num 模拟随机调用USER-SERVICE的不同实例 （参数值只能为0，1）
     * @return
     */
    @GetMapping("/getUser")
    public User getUser(Long id, Integer num){
        return this.service.getUser(id, num);
    }

    /**
     * getUser1 使用Ribbon负载均衡
     * @param id
     * @return
     */
    @GetMapping("/getUser1")
    public User getUser1(Long id){
        return this.service.getUser1(id);
    }

    /**
     * Hystrix测试
     *
     * @param id
     * @return
     */
    @GetMapping("/getUser2")
    public User getUser2(Long id){
        return this.service.getUserById(id);
    }
    /**
     * Hystrix测试
     *
     * @param ids
     * @return
     */
    @GetMapping("/getUserList")
    public List<User> getUserList(@RequestParam("ids") List<Long> ids){
        List<User> users = new ArrayList<>();
        for(Long id : ids) {
            users.add(this.service.getUserById(id));
        }
        return users;
    }

    @GetMapping("/testRibbonLoadBalancer")
    public void test(){
        //通过修改yml配置就可以验证RandomRule随机  RoundRobinRule轮询  策略
        for(int i = 1; i <= 50; i++){
            System.out.println(i + ":" + this.loadBalancerClient.choose("user-service"));
        }
    }
}
