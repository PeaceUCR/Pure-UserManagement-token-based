package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

//we don't need a view controller
//try to set up view<->url path in this way
@Configuration
public class WebViewConfig implements WebMvcConfigurer {
//public class WebViewConfig extends WebMvcConfigurerAdapter
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/changepassword").setViewName("/template/changepassword.html");
        registry.addViewController("/forgotpassword").setViewName("/template/forgotpassword.html");
        registry.addViewController("/signin").setViewName("/template/signin.html");
        registry.addViewController("/signup").setViewName("/template/signup.html");
        registry.addViewController("/profile").setViewName("/template/profile.html");
        registry.addViewController("/usermanagement").setViewName("/template/usermanagement.html");
    }
}
