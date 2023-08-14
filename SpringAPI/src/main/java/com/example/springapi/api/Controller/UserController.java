package com.example.springapi.api.Controller;

import com.example.springapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class UserController{

    private UserService userService;

    @Autowired
    public UserController(UserService userService ){
        this.userService= userService;
    }
    @GetMapping("/user")
    public Object getUser(@RequestParam Integer id){
        Optional user = userService.getUser(id);
        if(user.isPresent()){
            return user.get();
        }
        return null;
    }

}

