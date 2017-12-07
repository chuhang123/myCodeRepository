package com.mengyunzhi.controller;

import com.mengyunzhi.repository.WebAppMenu;
import com.mengyunzhi.service.WebAppMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by chuhang on 17-12-7
 * 前台菜单
 */

@RequestMapping("/WebAppMenu")
@RestController
public class WebAppMenuController {
    // 前台菜单
    @Autowired
    private WebAppMenuService webAppMenuService;

    @GetMapping("/")
    public List<WebAppMenu> getAll() {
        return webAppMenuService.getAll();
    }
}
