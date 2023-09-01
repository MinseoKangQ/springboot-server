package com.server.sumnote.user.controller;

import com.server.sumnote.user.entity.User;
import com.server.sumnote.user.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Login {

    private final UserService userService;

    public Login(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value="android")
    @ResponseBody
    public String androidResponse(@RequestBody User user) {

        User usingUser = userService.checkAndCreateUser(user.getEmail(), user.getName());
        System.out.println("Connection from Android");
        System.out.println("=== 매개변수로 받은 User ===");
        System.out.println("name: " + user.getName() + ", email: " + user.getEmail());
        System.out.println("=== Repository 에 존재하는 User ===");
        System.out.println("name: " + usingUser.getName() + ", email: " + usingUser.getEmail());

        return "success";
    }

    @PostMapping(value="delete-request-android")
    @ResponseBody
    public String androidDeleteResponse(@RequestBody User user) {
        userService.deleteUser(user.getEmail());
        return "deleted";
    }

}