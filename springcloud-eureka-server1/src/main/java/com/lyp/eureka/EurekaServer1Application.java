package com.lyp.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * EurekaserverApplication
 *
 * @author liyupeng
 * @since 2018-11-28 16:04
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServer1Application {
	public static void main(String[] args) {
		SpringApplication.run(EurekaServer1Application.class, args);
	}
}
