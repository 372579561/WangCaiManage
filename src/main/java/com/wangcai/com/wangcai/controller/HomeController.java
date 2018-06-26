package com.wangcai.com.wangcai.controller;

import com.wangcai.com.wangcai.constants.Constants;
import com.wangcai.com.wangcai.bean.HomePageImages;
import com.wangcai.com.wangcai.dao.HomePageImagesRepository;
import com.wangcai.com.wangcai.vo.ImagesLocation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@PropertySource("classpath:imagesRepository.properties")
@Controller
@RequestMapping("home")
public class HomeController {

    @Value("${images.location}")
    private String location;

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
            locations.add(location + homePageImage.getImagesLocation());
            hyperLinks.add(homePageImage.getHyperLink());
        }
        ImagesLocation imagesLocation =new ImagesLocation();
        imagesLocation.setImages_hyperlink(hyperLinks);
        imagesLocation.setImages_location(locations);
        model.addAttribute(Constants.IMAGES_LOCATION, imagesLocation);
        return "homePage";
    }
}

