package com.mengyunzhi.repository;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by chuhang on 17-12-6
 */
public interface RoleRepository extends CrudRepository<Role, Long> {
    Role findOneByName(String name);
    Role findOneByIsAdmin(Boolean isAdmin);
}
