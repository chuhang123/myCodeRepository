package com.mengyunzhi.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.mengyunzhi.repository.User;
import com.mengyunzhi.repository.WebAppMenu;
import com.mengyunzhi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.security.Principal;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by chuhang on 17-11-29
 * 用户控制器
 */
@RequestMapping("/User")
@RestController
public class UserController {
    static Logger logger = Logger.getLogger(UserController.class.getName());

    @Autowired
    UserService userService;

    @GetMapping("/{id}")
    public User get(@PathVariable Long id) {
        return userService.get(id);
    }

    @GetMapping("/login")
    public User login(Principal user) {
        logger.info("-----------------登录成功----------------");
        logger.info("登录用户:" + user.getName());

        return userService.getCurrentLoginUser();
    }

    @GetMapping("/getCurrentUserWebAppMenus/")
    public List<WebAppMenu> getCurrentUserWebAppMenus() {
        return userService.getCurrentUserWebAppMenus();
    }

    @PutMapping(value = "/updatePasswordAndNameOfCurrentUser/")
    public void updatePasswordAndNameOfCurrentUser(@RequestBody User user,
                                                   HttpServletResponse response) {
        try {
            userService.updatePasswordAndNameOfCurrentUser(user);
            response.setStatus(204);
        } catch (SecurityException e) {
            response.setStatus(205);
        }

        return;
    }

}
