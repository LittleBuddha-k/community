package com.littlebuddha.community.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 配置上传图片保存的印射对应的绝对路径
 */
@Configuration
public class ConfigurerUploadPicture implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
            //registry.addResourceHandler("/upload/**").addResourceLocations("file:E:\\upload");
    }
}
