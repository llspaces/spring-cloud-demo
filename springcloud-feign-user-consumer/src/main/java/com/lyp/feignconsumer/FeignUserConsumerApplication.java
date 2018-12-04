package com.lyp.feignconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * FeignUserConsumerApplication
 *
 * @author liyupeng
 * @since 2018-12-03 18:27
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class FeignUserConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(FeignUserConsumerApplication.class, args);
	}
}
