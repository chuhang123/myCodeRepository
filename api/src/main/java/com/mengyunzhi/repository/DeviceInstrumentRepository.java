package com.mengyunzhi.repository;

import com.mengyunzhi.entity.DeviceInstrument;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by chuhang on 18-2-12
 * 装置授权检定项目
 */
public interface DeviceInstrumentRepository extends PagingAndSortingRepository<DeviceInstrument, Long> {
}
