package com.lyp.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.retry.policy.SimpleRetryPolicy;
import org.springframework.retry.policy.TimeoutRetryPolicy;
import org.springframework.retry.support.RetryTemplate;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

/**
 * <p>@filename UserConsumerApplication</p>
 * <p>
 * <p>@description TODO</p>
 *
 * @author liyupeng
 * @version 1.0
 * @since 2018/11/30 10:59
 **/
@SpringBootApplication
@EnableDiscoveryClient
@EnableHystrix
public class UserConsumerApplication {

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        //超时重试：配置restTemplate超时，ribbon的超时参数配置后并不生效
        SimpleClientHttpRequestFactory simpleClientHttpRequestFactory = new SimpleClientHttpRequestFactory();
        //simpleClientHttpRequestFactory.setReadTimeout(1000);
        //simpleClientHttpRequestFactory.setConnectTimeout(1000);
        return new RestTemplate(simpleClientHttpRequestFactory);
    }

    public static void main(String[] args) {
        SpringApplication.run(UserConsumerApplication.class, args);
    }
}
