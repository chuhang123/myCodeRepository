package com.mengyunzhi.repository;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by chuhang on 17-11-29
 * 用户仓库
 */
public interface UserRepository extends CrudRepository<User, Long> {
}
