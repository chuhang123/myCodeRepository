package com.mengyunzhi.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;

import java.util.logging.Logger;

/**
 * Created by chuhang on 17-12-5
 */
@Configuration
public class GlobalRepositoryRestConfigurer extends RepositoryRestConfigurerAdapter {
    static private Logger logger = Logger.getLogger(GlobalRepositoryRestConfigurer.class.getName());
    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        logger.info("设置spring repository rest 的全局配置信息：与webConfig配置信息相同");
        config.getCorsRegistry()
                .addMapping("/**")          // 映射信息
                .allowedOrigins("*")                    // 跨域信息
                .allowedHeaders("*")                    // 允许的头信息
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS", "HEAD"); // 允许的请求方法信息
    }
}

