package com.mengyunzhi.repository;

import com.mengyunzhi.entity.StandardDevice;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by chuhang on 18-2-26
 * 标准器信息
 */
public interface StandardDeviceRepository extends PagingAndSortingRepository<StandardDevice, Long> {
    Iterable<StandardDevice> findAllByDeviceSetId(Long id);
}
