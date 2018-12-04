package com.lyp.userservice2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * UserService1Application
 *
 * @author liyupeng
 * @since 2018-11-29 17:10
 */
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan(basePackages = "com.lyp.userservice2.mapper")
public class UserService2Application {

	public static void main(String[] args) {
		SpringApplication.run(UserService2Application.class, args);
	}
}
