package com.mengyunzhi.service;

import com.mengyunzhi.entity.User;
import com.mengyunzhi.entity.WebAppMenu;

import java.security.Principal;
import java.util.List;

/**
 * Created by chuhang on 17-11-29
 * 用户接口
 */
public interface UserService {
    User get(Long id);

    User getCurrentLoginUser();

    Principal getCurrentLoginPrincipalUser();

    // 获取当前用户的前台菜单列表
    List<WebAppMenu> getCurrentUserWebAppMenus();

    void updatePasswordAndNameOfCurrentUser(User user);
}
