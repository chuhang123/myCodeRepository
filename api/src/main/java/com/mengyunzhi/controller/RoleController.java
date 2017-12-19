package com.mengyunzhi.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.mengyunzhi.repository.Role;
import com.mengyunzhi.service.RoleService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by chuhang on 17-12-12
 * 角色 控制器
 */
@RestController
@RequestMapping("/Role")
public class RoleController {
    private static Logger logger = Logger.getLogger(RoleController.class.getName());
    @Autowired
    private RoleService roleService;

    @GetMapping("/getAll")
    public List<Role> getAll() {
        return roleService.getAll();
    }
}
