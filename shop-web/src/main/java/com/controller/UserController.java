package com.controller;


import com.entity.User;
import com.github.pagehelper.PageInfo;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping(value = "/selectUser")
    @ResponseBody
    public User selectUser(@RequestParam(value = "id") String id){
        User user = userService.selectUser(Integer.parseInt(id));
        return user;
    }

    @PostMapping(value = "/inserUser")
    @ResponseBody
    public void inserUser(User user){
        userService.insertUser(user);
    }

    @GetMapping(value = "/selectAll")
    @ResponseBody
    public PageInfo selectAll(){
        PageInfo pageInfo = userService.selectAll();
        return pageInfo;
    }
}
