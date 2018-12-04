package com.lyp.feignconsumer.dao;

import com.lyp.feignconsumer.pojo.User;
import com.lyp.feignconsumer.service.FeignHystrixFallbackFactory;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * <p>@filename UserFeignClient</p>
 * <p>
 * <p>@description TODO</p>
 *
 * @author liyupeng
 * @version 1.0
 * @since 2018/12/3 18:29
 **/
@FeignClient(value = "user-service", fallbackFactory = FeignHystrixFallbackFactory.class)
@RequestMapping(value = "/user-service",method = RequestMethod.GET)
public interface UserFeignClient {

    @GetMapping("/getUser")
    User getUser(@RequestParam("id") Long id);
}
