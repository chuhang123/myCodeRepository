package com.mengyunzhi.service;

import com.mengyunzhi.repository.Role;

import javax.persistence.EntityNotFoundException;
import java.util.List;

/**
 * Created by chuhang on 17-12-12
 * 角色 M层
 */
public interface RoleService {
    //获取index界面数据
    List<Role> getAll();

    //获取当前id的角色
    Role get(Long id);

    // 更新
    Role update(Long id, Role role) throws EntityNotFoundException;
}
