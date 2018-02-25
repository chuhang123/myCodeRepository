package com.mengyunzhi.service;

import com.mengyunzhi.entity.Accuracy;
import com.mengyunzhi.entity.MeasureScale;
import com.mengyunzhi.entity.Specification;
import com.mengyunzhi.entity.StandardDeviceInstrumentType;
import com.mengyunzhi.repository.StandardDeviceInstrumentTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

/**
 * Created by chuhang on 18-2-23
 * 标准器类别
 */
@Service
public class StandardDeviceInstrumentTypeServiceImpl implements StandardDeviceInstrumentTypeService {
    private Logger logger = Logger.getLogger(StandardDeviceInstrumentTypeServiceImpl.class.getName());
    @Autowired
    StandardDeviceInstrumentTypeRepository standardDeviceInstrumentTypeRepository;

    @Override
    public StandardDeviceInstrumentType save(StandardDeviceInstrumentType standardDeviceInstrumentType) {
        this.addOneToManyForInstrumentType(standardDeviceInstrumentType);

        return standardDeviceInstrumentTypeRepository.save(standardDeviceInstrumentType);
    }

    @Override
    public StandardDeviceInstrumentType update(Long id, StandardDeviceInstrumentType standardDeviceInstrumentType) {
        standardDeviceInstrumentType.setId(id);
        this.addOneToManyForInstrumentType(standardDeviceInstrumentType);

        return standardDeviceInstrumentTypeRepository.save(standardDeviceInstrumentType);
    }

    /**
     * 添加oneToMany的属性
     * @param standardDeviceInstrumentType 器具类别
     */
    private void addOneToManyForInstrumentType(StandardDeviceInstrumentType standardDeviceInstrumentType) {
        logger.info("规格型号");
        for(Specification specification: standardDeviceInstrumentType.getSpecifications()) {
            specification.setInstrumentType(standardDeviceInstrumentType);
        }

        logger.info("精确度等级");
        for (Accuracy accuracy: standardDeviceInstrumentType.getAccuracies()) {
            accuracy.setInstrumentType(standardDeviceInstrumentType);
        }

        logger.info("测量范围");
        for (MeasureScale measureScale: standardDeviceInstrumentType.getMeasureScales()) {
            measureScale.setInstrumentType(standardDeviceInstrumentType);
        }
    }
}
