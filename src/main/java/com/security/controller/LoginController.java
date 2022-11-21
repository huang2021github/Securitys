package com.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("backend/login")
public class LoginController {

    @RequestMapping("/login")
    public String login(){
        return "views/login";
    }

    @RequestMapping("/index")
    public String index(){
        return "index";
    }
}
