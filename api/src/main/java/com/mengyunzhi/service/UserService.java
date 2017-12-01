package com.mengyunzhi.service;

import com.mengyunzhi.repository.User;

/**
 * Created by chuhang on 17-11-29
 * 用户接口
 */
public interface UserService {
    User get(Long id);
}
