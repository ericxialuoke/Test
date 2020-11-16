package com.deng.wj.controller;

import com.deng.wj.result.Result;
import com.deng.wj.pojo.User;
import com.deng.wj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    UserService userService;

    @CrossOrigin
    @PostMapping("/api/login")
    public Result login(@RequestBody User requestUser){

        String username=requestUser.getUsername();
        User user =userService.get(username,requestUser.getPassword());
        if(null==user){
            System.out.println("账号密码错误");
            return new Result(400);
        }else{
            return new Result(200);
        }

    }
}
