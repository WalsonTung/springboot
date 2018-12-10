package com.zhengzhaoxi.webdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class WebDemoApplication {

	@RequestMapping("/sayhi")
	public String index() {
		return "hello spring root";
	}
	public static void main(String[] args) {
		SpringApplication.run(WebDemoApplication.class, args);
	}
}
