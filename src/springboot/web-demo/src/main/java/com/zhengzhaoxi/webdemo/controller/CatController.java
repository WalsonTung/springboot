package com.zhengzhaoxi.webdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/cat")
public class CatController {

	@RequestMapping("/")
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView("/index");
		modelAndView.addObject("sayHi", "Hello Cat.");
		
		return modelAndView;
	}
}
