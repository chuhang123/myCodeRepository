package com.mengyunzhi.service;

import com.mengyunzhi.entity.DeviceSet;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


/**
 * Created by chuhang on 18-2-28
 * 计量标准装置
 */
public interface DeviceSetService {
    Page<DeviceSet> pageAllBySpecification(String name, String code, Pageable pageable);
}
