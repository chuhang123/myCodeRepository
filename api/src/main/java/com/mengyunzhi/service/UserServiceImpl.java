package com.mengyunzhi.service;

import com.mengyunzhi.entity.Role;
import com.mengyunzhi.entity.User;
import com.mengyunzhi.entity.WebAppMenu;
import com.mengyunzhi.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.security.Principal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by chuhang on 17-11-29
 * 用户接口实现
 */
@Service
public class UserServiceImpl implements UserService {
    static private User currentTestLoginUser;       // 当前登录用户
    private Principal currentLoginPrincipalUser;    // 当前登录认证用户
    @Autowired
    private WebAppMenuRepository webAppMenuRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public Principal getCurrentLoginPrincipalUser() {
        currentLoginPrincipalUser = SecurityContextHolder.getContext().getAuthentication();
        return currentLoginPrincipalUser;
    }

    @Override
    @Transactional
    public List<WebAppMenu> getCurrentUserWebAppMenus() {
        Set<Long> roleIds = new HashSet<>();
        for (Role role : this.getCurrentLoginUser().getRoles()) {
            roleIds.add(role.getId());
        }

        List<WebAppMenu> webAppMenus = new ArrayList<>();
        if (roleIds.size() > 0) {
            webAppMenus = webAppMenuRepository.findAllByRoleIds(roleIds);
        }

        return webAppMenus;
    }

    @Override
    public void updatePasswordAndNameOfCurrentUser(User user) {
        User currentUser = this.getCurrentLoginUser();

        if (!currentUser.getPassword().equals(user.getPassword())) {
            throw new SecurityException("原密码错误");
        }

        currentUser.setName(user.getName());
        currentUser.setPassword(user.getRePassword());
        userRepository.save(currentUser);

        return;
    }

    @Override
    public User get(Long id) {
        return userRepository.findOne(id);
    }

    @Override
    public User getCurrentLoginUser() {
        if (null != this.currentTestLoginUser) {
            return this.currentTestLoginUser;
        } else {
            String username = getCurrentLoginPrincipalUser().getName();
            User currentLoginUser = userRepository.findOneByUsername(username);
            return currentLoginUser;
        }
    }
}
