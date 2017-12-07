package com.mengyunzhi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Set;

/**
 * Created by chuhang on 17-12-6
 */
public interface WebAppMenuRepository extends CrudRepository<WebAppMenu, Long>, JpaRepository<WebAppMenu, Long> {
    /**
     * 获取某个 角色ID SET拥有的所有前台菜单权限
     * @param roleIds
     * @return
     */
    @Query(value = "select w from #{#entityName} w inner join w.roles r where r.id in (:roleIds)")
    List<WebAppMenu> findAllByRoleIds(@Param("roleIds") Set<Long> roleIds);
    WebAppMenu findOneByRouteName(String routeName);
}
