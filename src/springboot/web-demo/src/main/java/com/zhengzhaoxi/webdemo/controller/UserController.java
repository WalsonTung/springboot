package com.zhengzhaoxi.webdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.zhengzhaoxi.springboot.model.User;
import com.zhengzhaoxi.springboot.mybatis.UserMapper;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserMapper userMapper;

	@RequestMapping("/index")
    public ModelAndView index() {
		
        User user = new User();
        user.setAge(18);
        user.setName("Adam");
        user.setPwd("123456");
        userMapper.insert(user);
        ModelAndView modelAndView = new ModelAndView("/user/index");
        modelAndView.addObject("count", userMapper.findAll().size());
        return modelAndView;
    }
}
