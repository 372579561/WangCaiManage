package com.wangcai.com.wangcai.controller;

import com.wangcai.com.wangcai.Constants.Constants;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@PropertySource("classpath:imagesRepository.properties")
@Controller
@RequestMapping("home")
public class Home {

    @Value("${images.location}")
    private String location;

    @Value("${images.HyperLink}")
    private String hyperLink;
    @RequestMapping("/homePage")
    public String homePage(Model model) {
        model.addAttribute(Constants.IMAGES_LOCATION,location);
        model.addAttribute(Constants.IMAGES_HYPERLINK,hyperLink);
        System.out.println(location+hyperLink);
        return "homePage";
    }
}

