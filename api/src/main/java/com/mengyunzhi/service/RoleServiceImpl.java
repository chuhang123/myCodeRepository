package com.mengyunzhi.service;

import com.mengyunzhi.entity.Role;
import com.mengyunzhi.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by chuhang on 17-12-12
 * 角色 M层实现
 */
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<Role> getAll() {
        List<Role> list = new ArrayList<>();
        list = (List<Role>) roleRepository.findAll();
        return list;
    }

    @Override
    public Role get(Long id) {
        return roleRepository.findOne(id);
    }

    @Override
    public Role update(Long id, Role role) throws EntityNotFoundException {
        Role oldRole = roleRepository.findOne(id);
        if (null == oldRole) {
            throw new EntityNotFoundException();
        } else {
            role.setId(id);
            roleRepository.save(role);
        }

        return role;
    }
}
