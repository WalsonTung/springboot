package com.zhengzhaoxi.webdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
@MapperScan("com.zhengzhaoxi.springboot.mybatis")
public class WebDemoApplication extends SpringBootServletInitializer{
	
	 /**
                  *   重写configure方法，加载启动类
     * @param application
     * @return
     */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(WebDemoApplication.class);
    }
	
	public static void main(String[] args) {
		SpringApplication.run(WebDemoApplication.class, args);
	}
}
