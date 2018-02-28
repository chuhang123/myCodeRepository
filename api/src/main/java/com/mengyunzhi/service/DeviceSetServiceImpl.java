package com.mengyunzhi.service;

import com.mengyunzhi.entity.DeviceSet;
import com.mengyunzhi.repository.DeviceSetRepository;
import com.mengyunzhi.specs.DeviceSetSpecs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by chuhang on 18-2-28
 * 计量标准装置
 */
@Service
public class DeviceSetServiceImpl implements DeviceSetService {

    @Autowired
    DeviceSetRepository deviceSetRepository;

    public Page<DeviceSet> pageAllBySpecification(String name, String code, Pageable pageable){
        Map<String, Object> map = new HashMap<>();
        map.put("name", name);
        map.put("code", code);
        org.springframework.data.jpa.domain.Specification specification = DeviceSetSpecs.base(map);
        Page<DeviceSet> deviceSetPage = deviceSetRepository.findAll(specification, pageable);
        return deviceSetPage;
    }
}
