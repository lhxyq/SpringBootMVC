package com.lh.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by LH 2446059046@qq.com on 2017/7/17.
 */
@Controller
@RequestMapping("/login")
public class LoginController {

    @GetMapping
    public String index() {
        return "home/login";
    }

}
