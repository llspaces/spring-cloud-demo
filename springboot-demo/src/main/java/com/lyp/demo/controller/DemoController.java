package com.lyp.demo.controller;

import com.lyp.demo.pojo.User;
import com.lyp.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * <p>@filename DemoController</p>
 * <p>
 * <p>@description TODO</p>
 *
 * @author liyupeng
 * @version 1.0
 * @since 2018/11/27 15:01
 **/
//@RestController(等价于@Controller和@ResponseBody)
@Controller
@RequestMapping("/demo")
public class DemoController {
    @Autowired
    private UserService userService;

    @GetMapping("/hello")
    public String hello() {
        return "my first springboot hello world~";
    }

    @ResponseBody
    @GetMapping("/getAll")
    public List<User> getAll(){
        return this.userService.getAll();
    }

    @GetMapping("/getAll1")
    public String getAll1(Model model){
        List<User> users = this.userService.getAll();
        model.addAttribute("users", users);
        return "users";
    }

}
