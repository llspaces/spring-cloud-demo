package com.lyp.demo;

import com.lyp.demo.pojo.User;
import com.lyp.demo.util.JsonUtil;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

/**
 * <p>@filename HttpClientTest</p>
 * <p>
 * <p>@description TODO</p>
 *
 * @author liyupeng
 * @version 1.0
 * @since 2018/11/28 10:53
 **/

public class HttpClientTest {

    CloseableHttpClient httpClient;

    @Before
    public void init(){
        httpClient = HttpClients.createDefault();
    }

    @Test
    public void testGet(){
        HttpGet get = new HttpGet("https://www.baidu.com");
        try {
            String response = this.httpClient.execute(get, new BasicResponseHandler());
            System.out.println(response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetUser(){
        HttpGet get = new HttpGet("http://localhost/demo/getAll");
        try {
            String response = this.httpClient.execute(get, new BasicResponseHandler());
            System.out.println(response);
            List<User> users = JsonUtil.parseList(response, User.class);
            System.out.println(users);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @After
    public void close(){
        try {
            if(null != httpClient)
                httpClient.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
