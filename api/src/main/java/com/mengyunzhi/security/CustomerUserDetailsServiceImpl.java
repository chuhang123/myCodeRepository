package com.mengyunzhi.security;

import com.mengyunzhi.entity.User;
import com.mengyunzhi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chuhang on 17-12-5
 */
@Service
public class CustomerUserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 如果未找到相关用户，则抛出UsernameNotFoundException异常供spring security获取
        User user = userRepository.findOneByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("用户名不存在");
        } else if (user.getStatus() != 0) {
            throw new UsernameNotFoundException("用户状态不正常");
        }

        // 用户拥有的认证（角色）列表。 SimpleGrantedAuthority简单授权
        List<SimpleGrantedAuthority> authorityList = new ArrayList<>();

        // 向简单授权中添加角色
        authorityList.add(new SimpleGrantedAuthority("Admin"));

        // 将带有用户名、密码、角色列表的 org.springframework.security.core.userdetails.User 对象返回
        return new  org.springframework.security.core.userdetails.User(user.getUsername(),
                user.getPassword(), authorityList);
    }
}
