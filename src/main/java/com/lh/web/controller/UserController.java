package com.lh.web.controller;

import com.lh.web.domain.User;
import com.lh.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by LH 2446059046@qq.com on 2017/7/16.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public String add(User user) {
        try {
            userService.add(user);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return "redirect:/";
    }
}