package com.mengyunzhi.service;

import com.mengyunzhi.entity.StandardDeviceInstrumentType;

/**
 * Created by chuhang on 18-2-23
 */
public interface StandardDeviceInstrumentTypeService {
    StandardDeviceInstrumentType save(StandardDeviceInstrumentType standardDeviceInstrumentType);
    StandardDeviceInstrumentType update(Long id, StandardDeviceInstrumentType standardDeviceInstrumentType);
}
