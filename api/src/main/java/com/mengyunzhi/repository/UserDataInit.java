package com.mengyunzhi.repository;

import com.mengyunzhi.ApiInitDataListener;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by chuhang on 17-12-6
 */
@Component
public class UserDataInit extends ApiInitDataListener {
    private Logger logger = Logger.getLogger(UserDataInit.class.getName());

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Autowired
    public UserDataInit(RoleRepository roleRepository, UserRepository userRepository) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        if (null == userRepository.findOneByUsername("admin")) {
            User adminUser = new User();
            adminUser.setName("系统管理员");
            adminUser.setStatus(0);
            adminUser.setPinyin("xitongguanliyuan");
            adminUser.setUsername("admin");
            adminUser.setPassword("admin");
            userRepository.save(adminUser);

            Role adminRole = roleRepository.findOneByName("系统管理员");
            Set<Role> roles = new HashSet<>();
            roles.add(adminRole);
            adminUser.setRoles(roles);

            logger.info("为测试器具用户添加一个用户");
            Role role = roleRepository.findOneByIsAdmin(true);
            User user1 = new User();
            user1.addRole(role);
            user1.setUsername("user1");
            user1.setPassword("user1");
            user1.setName("测试器具用户");
            user1.setStatus(0);
            userRepository.save(user1);

        }
    }

    @Override
    public int getOrder() {
        return HIGHEST_PRECEDENCE + 10;
    }
}
