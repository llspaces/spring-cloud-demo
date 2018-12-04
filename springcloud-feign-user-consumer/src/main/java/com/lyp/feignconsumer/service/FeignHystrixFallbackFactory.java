package com.lyp.feignconsumer.service;

import com.lyp.feignconsumer.dao.UserFeignClient;
import com.lyp.feignconsumer.pojo.User;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * <p>@filename FeignHystrixFallbackFactory</p>
 * <p>
 * <p>@description TODO</p>
 *
 * @author liyupeng
 * @version 1.0
 * @since 2018/12/4 9:48
 **/
@Component
public class FeignHystrixFallbackFactory implements FallbackFactory<UserFeignClient>{
    @Override
    public UserFeignClient create(Throwable throwable) {
        return new UserFeignClient() {
            @Override
            public User getUser(Long id) {
                System.out.println("getUser2方法异常，超时熔断!");
                User user = new User();
                user.setName("数据获取异常");
                return user;
            }
        };
    }
}
