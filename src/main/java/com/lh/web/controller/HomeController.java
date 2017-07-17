package com.lh.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by LH 2446059046@qq.com on 2017/7/15.
 */

@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping("/error")
    public String error() {
        return "home/error";
    }

    @GetMapping
    public String home() {
        return "home/home";
    }
}
