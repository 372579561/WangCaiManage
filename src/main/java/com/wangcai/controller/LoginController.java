package com.wangcai.controller;

import com.wangcai.model.User;
import com.wangcai.constants.Constants;
import com.wangcai.dao.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("login")
public class LoginController {

    private UserRepository userRepository;

    public LoginController(UserRepository userRepository) {
        super();
        this.userRepository = userRepository;
    }

    @RequestMapping("loginPage")
    public String home() {
        return "loginPage";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public String login(User user, HttpSession session) {
        User dataUser = userRepository.findByUserName(user.getUserName());
        if (dataUser != null && dataUser.getPassword().equals(user.getPassword())) {
            session.setAttribute(Constants.USER_LOGIN, dataUser);
            Date date = new Date();
            dataUser.setLastTime(date);
            userRepository.save(dataUser);
            return "success";
        }
        return "fail";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public String register(User user, HttpSession session) {
        synchronized (this) {
            if (userRepository.findByUserName(user.getUserName()) != null) {
                return "fail";
            }
            user.setCreateTime(new Date());
            user = userRepository.save(user);
            if (user != null) {
                return "success";
            }
            return "fail";
        }

    }

    @RequestMapping(value = "/register/remote", method = RequestMethod.POST)
    @ResponseBody
    public String remote(String userName, HttpSession session) {
        User user = userRepository.findByUserName(userName);
        if (user == null) {
            return "success";
        }
        return "fail";
    }

    @RequestMapping("list")
    @ResponseBody
    public List<User> list() {
        return userRepository.findAll();
    }
}
