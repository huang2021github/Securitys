package com.security.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("backend/security")
public class RouterController {


    @RequestMapping("/index/pc")
    public String PCOne(){
        return "PC所有用户 均可访问的接口";
    }

    @RequestMapping("/indexTo/pc")
    public String PCTwo(){
        return "PC指定用户可访问接口1";
    }

    @RequestMapping("/indexTo/pct")
    public String PCThree(){
        return "PC指定用户可访问接口2";
    }

    //获取认证信息 Authentication information
    public void getAuthentication(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();//或者强转User获取
        System.out.println("身份信息：" + authentication.getPrincipal());
        System.out.println("权限信息：" + authentication.getAuthorities());
    }

    /*@RequestMapping("/toLogin")
    public String toLogin(){
        return "views/login";
    }

    @RequestMapping("/level1/{id}")
    public String level1(@PathVariable int id){
        return "views/level1/" + id;
    }

    @RequestMapping("/level2/{id}")
    public String level2(@PathVariable int id){
        return "views/level2/" + id;
    }

    @RequestMapping("/level3/{id}")
    public String level3(@PathVariable int id){
        return "views/level3/" + id;
    }*/

}
