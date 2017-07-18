package com.lh.web.controller;

import com.lh.web.domain.User;
import com.lh.web.service.UserService;
import com.lh.web.util.common.Result;
import com.lh.web.util.common.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by LH 2446059046@qq.com on 2017/7/16.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public String add(@Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            System.out.println(bindingResult.getFieldError().getDefaultMessage());
        else
            userService.add(user);
        return "redirect:/";
    }

    @GetMapping("/userInfo/{username}")
    public String userInfo(@PathVariable("username") String username, ModelMap map) {
        User user = userService.findByName(username);
        map.addAttribute("users", user);
        return "user/info";
    }

    @PostMapping("/create")
    @ResponseBody
    public Result<User> crate(@Valid User user, BindingResult bindingResult) throws Exception{
        if (bindingResult.hasErrors())
            return null;
        else
            return ResultUtil.success(userService.create(user));
    }
}
