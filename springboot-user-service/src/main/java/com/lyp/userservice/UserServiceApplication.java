package com.lyp.userservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * UserServiceApplication
 *
 * @author liyupeng
 * @since 2018-11-28 14:06
 */
@SpringBootApplication
@MapperScan(basePackages = "com.lyp.userservice.mapper")
public class UserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}
}
