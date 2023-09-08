package com.server.sumnote.user.controller;

import com.server.sumnote.user.entity.User;
import com.server.sumnote.user.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
@RequiredArgsConstructor
@Component("loginController")
@Api(tags = {"Login API"})
public class Login {

    private final UserService userService;

    @ResponseBody
    @PostMapping("/android")
    @ApiOperation(value = "카카오 - 유저 생성")
    public String androidResponse(@RequestBody User user) {

        User usingUser = userService.checkAndCreateUser(user.getEmail(), user.getName());
        System.out.println(usingUser.getEmail());
        System.out.println(usingUser.getName());
        return "스프링부트에서 유저 생성 성공";
    }

    @ResponseBody
    @DeleteMapping("/delete")
    @ApiOperation(value = "카카오 - 유저 삭제")
    public String androidDeleteResponse(@RequestBody User user) {
        userService.deleteUser(user.getEmail());
        return "스프링부트에서 유저 삭제 성공";
    }

}