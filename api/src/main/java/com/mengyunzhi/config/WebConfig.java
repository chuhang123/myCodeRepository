package com.mengyunzhi.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.logging.Logger;

/**
 * Created by chuhang on 17-12-4
 */
@Configuration
@EnableWebMvc
public class WebConfig extends WebMvcConfigurerAdapter {
    static private Logger logger = Logger.getLogger(WebConfig.class.getName());

    // 配置允许跨域请求的映射(路由、地址、URL）信息
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        logger.info("设置请求信息: 路由信息，允许的header，跨域地址，允许方法，暴露的x-auth-token");
        registry.addMapping("/**")
                .allowedHeaders("*")
                .allowedOrigins("*")
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS", "HEAD", "PATCH")
                .exposedHeaders("x-auth-token")
                .maxAge(3600);
    }
}
