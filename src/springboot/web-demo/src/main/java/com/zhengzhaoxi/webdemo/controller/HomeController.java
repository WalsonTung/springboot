package com.zhengzhaoxi.webdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/home")
public class HomeController {

	@RequestMapping("/index")
	public ModelAndView index() {
		ModelAndView view = new ModelAndView("/home/index");
		view.addObject("name", "信的博客");
		
		return view;
	}
}
