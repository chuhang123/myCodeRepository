package com.mengyunzhi.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

/**
 * Created by chuhang on 17-12-6
 */
@Component
public class RoleDataInit implements ApplicationListener<ContextRefreshedEvent>, Ordered {
    private static Logger logger = Logger.getLogger(RoleDataInit.class.getName());
    @Autowired
    private RoleRepository roleRepository;
    @Autowired private WebAppMenuRepository webAppMenuRepository;
    @Autowired private WebAppMenuDataInit webAppMenuDataInit;

    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent){
        List<Role> roles1 = (List<Role>) roleRepository.findAll();
        if (roles1.size() == 0) {
            Set<Role> roles = new HashSet<>();

            Role adminRole = new Role();
            adminRole.setName("系统管理员");
            adminRole.setPinyin("xitongguanliyuan");
            ArrayList<WebAppMenu> webAppMenus = (ArrayList<WebAppMenu>) webAppMenuRepository.findAll();
            adminRole.setWebAppMenus(new HashSet<>(webAppMenus));
            adminRole.setAdmin(true);
            roles.add(adminRole);

            Role userRole = new Role();
            userRole.setName("器具用户");
            userRole.setPinyin("qijuyonghu");
            roles.add(userRole);

            roleRepository.save(roles);
        }
        return;
    }

    @Override
    public int getOrder()
    {
        return webAppMenuDataInit.getOrder() + 10;
    }
}
