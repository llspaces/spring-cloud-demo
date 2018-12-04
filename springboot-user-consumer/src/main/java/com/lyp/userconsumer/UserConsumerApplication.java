package com.lyp.userconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * UserConsumerApplication
 *
 * @author liyupeng
 * @since 2018-11-28 14:19
 */
@SpringBootApplication
public class UserConsumerApplication {

	@Bean
	public RestTemplate restTemplate(){
		//构造函数传入不同参数可以使用不通的http访问方式，默认为jdk的
		return new RestTemplate(new OkHttp3ClientHttpRequestFactory());
	}

	public static void main(String[] args) {
		SpringApplication.run(UserConsumerApplication.class, args);
	}
}
