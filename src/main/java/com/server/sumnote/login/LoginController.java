package com.server.sumnote.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {
    @PostMapping(value="android")
    @ResponseBody
    public String androidResponse(@RequestBody User user) {

        System.out.println("Connection from Android");
        System.out.println("name: " + user.getName() + ", email: " + user.getEmail());

        return "1";
    }
}
