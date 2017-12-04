package com.mengyunzhi.service;

import com.mengyunzhi.repository.User;
import com.mengyunzhi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.security.Principal;

/**
 * Created by chuhang on 17-11-29
 * 用户接口实现
 */
@Service
public class UserServiceImpl implements UserService {
    static private User currentTestLoginUser;       // 当前登录用户
    private Principal currentLoginPrincipalUser;    // 当前登录认证用户

    @Autowired
    UserRepository userRepository;

    @Override
    public Principal getCurrentLoginPrincipalUser() {
        currentLoginPrincipalUser = SecurityContextHolder.getContext().getAuthentication();
        return currentLoginPrincipalUser;
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
