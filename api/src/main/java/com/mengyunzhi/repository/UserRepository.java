package com.mengyunzhi.repository;

import com.mengyunzhi.entity.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by chuhang on 17-11-29
 * 用户仓库
 */
public interface UserRepository extends CrudRepository<User, Long> {
    User findOneByUsername(String username);
}
