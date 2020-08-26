package com.littlebuddha.community.config.interceptor;

import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 白名单，即：不要求登录即可访问的路径
        List<String> patterns = new ArrayList<>();
        patterns.add("/js/**");
        patterns.add("/css/**");
        patterns.add("/images/**");
        patterns.add("/fonts/**");
        patterns.add("/jquery/**");
        patterns.add("/upload/**");
        patterns.add("/sys/register.html");
        patterns.add("/sys/login.html");
        patterns.add("/sys/index.html");
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**").excludePathPatterns(patterns);
    }
}
