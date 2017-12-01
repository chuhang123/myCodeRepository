package com.mengyunzhi.controller;

import com.mengyunzhi.repository.User;
import com.mengyunzhi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

/**
 * Created by chuhang on 17-11-29
 * 用户控制器
 */
@RequestMapping("/User")
@RestController
public class UserController {
    static Logger log = Logger.getLogger(UserController.class.getName());

    @Autowired
    UserService userService;

    @GetMapping("/{id}")
    public User get(@PathVariable Long id) {
        return userService.get(id);
    }

}
