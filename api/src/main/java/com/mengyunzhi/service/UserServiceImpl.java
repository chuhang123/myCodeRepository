package com.mengyunzhi.service;

import com.mengyunzhi.repository.User;
import com.mengyunzhi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by chuhang on 17-11-29
 * 用户接口实现
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public User get(Long id) {
        return userRepository.findOne(id);
    }
}
