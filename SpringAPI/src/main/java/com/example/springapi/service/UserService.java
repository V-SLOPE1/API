package com.example.springapi.service;

import com.example.springapi.api.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private List<User> userList;

    public UserService(){
        userList = new ArrayList<>();


        User user1=new User( 1,"thato", 40, "thato@gmail.com");
       User user2=new User(1, "thato", 40, "thato@gmail.com");

        userList.addAll(Arrays.asList(user1,user2));
    }
    public Optional<User> getUser(Integer id) {
        Optional optional= Optional.empty();
        for(User user: userList){
            if(id== user.getId()){
                optional = Optional.of(user);
                return optional;
            }
        }
        return null;
    }
}
