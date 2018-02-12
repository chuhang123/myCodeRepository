package com.mengyunzhi.controller;

import com.mengyunzhi.entity.StandardDeviceInstrumentType;
import com.mengyunzhi.repository.StandardDeviceInstrumentTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.SortDefault;
import org.springframework.web.bind.annotation.*;

/**
 * Created by chuhang on 18-2-12
 * 标准器类别
 */
//@Api(tags = "StandardDeviceInstrumentType 标准器类别", description = "标准器器具类别Controller")
@RequestMapping("/StandardDeviceInstrumentType")
@RestController
public class StandardDeviceInstrumentTypeController {
    @Autowired
    StandardDeviceInstrumentTypeRepository standardDeviceInstrumentTypeRepository;

    @GetMapping("/pageByDisciplineId/{disciplineId}")
    public Page<StandardDeviceInstrumentType> pageByDisciplineId(@PathVariable Long disciplineId, @SortDefault.SortDefaults(@SortDefault(sort = "id", direction = Sort.Direction.DESC)) Pageable pageable) {
        return standardDeviceInstrumentTypeRepository.pageByDisciplineId(disciplineId, pageable);
    }

    @GetMapping("/getAll")
    public Iterable<StandardDeviceInstrumentType> getAll() {
        return standardDeviceInstrumentTypeRepository.findAll();
    }

    @PostMapping("/")
    public StandardDeviceInstrumentType save(@RequestBody StandardDeviceInstrumentType standardDeviceInstrumentType) {
        return standardDeviceInstrumentTypeRepository.save(standardDeviceInstrumentType);
    }

    @GetMapping("/{id}")
    public StandardDeviceInstrumentType get(@PathVariable Long id) {
        return standardDeviceInstrumentTypeRepository.findOne(id);
    }
}
