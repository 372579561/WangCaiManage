package com.wangcai.com.wangcai.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("home")
public class Home {
    @RequestMapping("/homePage")
    public String homePage() {
        return "homePage";
    }
}
