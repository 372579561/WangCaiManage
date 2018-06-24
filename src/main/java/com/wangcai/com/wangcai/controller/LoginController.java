package com.wangcai.com.wangcai.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("Login")
public class LoginController
{
    @RequestMapping("home")
    public String  Login(){
        return "home";
    }
}
