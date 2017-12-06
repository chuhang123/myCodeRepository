package com.mengyunzhi.config;

import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

import java.util.logging.Logger;

/**
 * Created by chuhang on 17-12-4
 * Spring 安全设置
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    static private Logger logger = Logger.getLogger(SecurityConfig.class.getName());

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        logger.info("设置httpSecurity:认证方式，授权请求，跨域应用，CSRF信息等");
        httpSecurity
                // 基本认证方式BasicAuth.相对还有Digest Auth,OAuth1.0,2.0等
                .httpBasic()
                .and()
                // 设置授权请求,如果是/User/login则允许所有操作
                .authorizeRequests()
                .antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
                .antMatchers("/User/login"
                ).permitAll()
                .anyRequest().authenticated()
                .and()

                // 设置为跨域应用
                .cors()
                .and()

                // 设置CSRF信息。否则在进行请求，将报csrf token not found错误
                .csrf()
                .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())

                // 设置禁用csrf检测。TODO:深入学习csrf()在此的作用
                .and()
                .csrf().disable();
    }
}
