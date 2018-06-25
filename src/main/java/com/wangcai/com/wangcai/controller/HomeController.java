package com.wangcai.com.wangcai.controller;

import com.wangcai.com.wangcai.Constants.Constants;
import com.wangcai.com.wangcai.bean.HomePageImages;
import com.wangcai.com.wangcai.dao.HomePageImagesRepository;
import com.wangcai.com.wangcai.dao.UserRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@PropertySource("classpath:imagesRepository.properties")
@Controller
@RequestMapping("home")
public class HomeController {

    @Value("${images.location}")
    private String location;

    @Value("${images.HyperLink}")
    private String hyperLink;

    private HomePageImagesRepository homePageImagesRepository;

    public HomeController(HomePageImagesRepository homePageImagesRepository) {
        super();
        this.homePageImagesRepository = homePageImagesRepository;
    }

    @RequestMapping("/homePage")
    public String homePage(Model model) {
        List<HomePageImages> homePageImages = homePageImagesRepository.findByStatus(1);
        List locations = new ArrayList();
        List hyperLinks = new ArrayList();
        for (HomePageImages homePageImage : homePageImages) {
            locations.add(location+homePageImage.getImagesLocation());
            hyperLinks.add(hyperLink+homePageImage.getImagesLocation());
        }
        model.addAttribute(Constants.IMAGES_LOCATION, locations);
        model.addAttribute(Constants.IMAGES_HYPERLINK, hyperLinks);
        System.out.println(locations);
        return "homePage";
    }
}

