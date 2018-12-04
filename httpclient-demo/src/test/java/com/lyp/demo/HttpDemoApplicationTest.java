package com.lyp.demo;

import com.lyp.demo.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * <p>@filename HttpDemoApplicationTest</p>
 * <p>
 * <p>@description TODO</p>
 *
 * @author liyupeng
 * @version 1.0
 * @since 2018/11/28 10:53
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = HttpDemoApplication.class)
public class HttpDemoApplicationTest {
    //使用RestTemplate
    @Autowired
    private RestTemplate restTemplate;

    @Test
    public void httpGetUser(){
        List<User> users = this.restTemplate.getForObject("http://localhost/demo/getAll" , List.class);
        System.out.println(users);
    }

}
