package com.mengyunzhi.service;

import com.mengyunzhi.repository.User;

import java.security.Principal;

/**
 * Created by chuhang on 17-11-29
 * 用户接口
 */
public interface UserService {
    User get(Long id);

    User getCurrentLoginUser();

    Principal getCurrentLoginPrincipalUser();
}
