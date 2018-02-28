package com.mengyunzhi.repository;

import com.mengyunzhi.entity.DeviceSet;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by chuhang on 18-2-12
 * 计量标准装置
 */
public interface DeviceSetRepository extends PagingAndSortingRepository<DeviceSet, Long>, JpaSpecificationExecutor {
}
