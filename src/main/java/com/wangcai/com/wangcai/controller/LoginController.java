package com.wangcai.com.wangcai.controller;

import com.wangcai.com.wangcai.bean.User;
import com.wangcai.com.wangcai.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("login")
public class LoginController
{

    private UserRepository userRepository;

    public LoginController(UserRepository userRepository) {
        super();
        this.userRepository = userRepository;
    }

    @RequestMapping("home")
    public String home(){
        return "home";
    }

    @RequestMapping(value="/login",method = RequestMethod.POST)
    @ResponseBody
    public String login(User user){
        User dataUser=userRepository.findByUserName(user.getUserName());
        if(dataUser.getPassword().equals(user.getPassword())){
            return "success";
        }
        return "fail";
    }

    @RequestMapping("list")
    @ResponseBody
    public List<User> list(){
        return userRepository.findAll();
    }
}
