package com.mengyunzhi.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.mengyunzhi.entity.StandardDeviceInstrumentType;
import com.mengyunzhi.jsonView.StandardDeviceInstrumentTypeJsonView;
import com.mengyunzhi.repository.StandardDeviceInstrumentTypeRepository;
import com.mengyunzhi.service.StandardDeviceInstrumentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.SortDefault;
import org.springframework.http.HttpStatus;
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
    @Autowired
    StandardDeviceInstrumentTypeService standardDeviceInstrumentTypeService;

    @GetMapping("/pageByDisciplineId/{disciplineId}")
    @JsonView(StandardDeviceInstrumentTypeJsonView.baseJsonView.class)
    public Page<StandardDeviceInstrumentType> pageByDisciplineId(@PathVariable Long disciplineId, @SortDefault
            .SortDefaults(@SortDefault(sort = "id", direction = Sort.Direction.DESC)) Pageable pageable) {
        Page<StandardDeviceInstrumentType> standardDeviceInstrumentTypes = standardDeviceInstrumentTypeRepository
                .pageByDisciplineId(disciplineId, pageable);
        return standardDeviceInstrumentTypes;
    }

    @GetMapping("/getAllByDisciplineId/{disciplineId}")
    @JsonView(StandardDeviceInstrumentTypeJsonView.baseJsonView.class)
    public Iterable<StandardDeviceInstrumentType> getAllByDisciplineId(@PathVariable Long disciplineId) {
        Iterable<StandardDeviceInstrumentType> standardDeviceInstrumentTypes = standardDeviceInstrumentTypeRepository
                .getAllByDisciplineId(disciplineId);
        return standardDeviceInstrumentTypes;
    }

    @GetMapping("/getAll")
    @JsonView(StandardDeviceInstrumentTypeJsonView.baseJsonView.class)
    public Iterable<StandardDeviceInstrumentType> getAll() {
        return standardDeviceInstrumentTypeRepository.findAll();
    }

    @PostMapping("/")
    @JsonView(StandardDeviceInstrumentTypeJsonView.baseJsonView.class)
    public StandardDeviceInstrumentType save(@RequestBody StandardDeviceInstrumentType standardDeviceInstrumentType) {
        return standardDeviceInstrumentTypeService.save(standardDeviceInstrumentType);
    }

    @GetMapping("/{id}")
    @JsonView(StandardDeviceInstrumentTypeJsonView.baseJsonView.class)
    public StandardDeviceInstrumentType get(@PathVariable Long id) {
        return standardDeviceInstrumentTypeRepository.findOne(id);
    }

    @PutMapping("/{id}")
    @JsonView(StandardDeviceInstrumentTypeJsonView.baseJsonView.class)
    public StandardDeviceInstrumentType update(@PathVariable Long id, @RequestBody StandardDeviceInstrumentType
            standardDeviceInstrumentType) {
        return standardDeviceInstrumentTypeService.update(id, standardDeviceInstrumentType);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        standardDeviceInstrumentTypeRepository.delete(id);
        return;
    }

    @GetMapping("/getAllByInstrumentFirstLevelTypeId/{instrumentFirstLevelTypeId}")
    @JsonView(StandardDeviceInstrumentTypeJsonView.baseJsonView.class)
    public Iterable<StandardDeviceInstrumentType> getAllByInstrumentFirstLevelTypeId(@PathVariable Long
            
                                                                                                 instrumentFirstLevelTypeId) {
        return standardDeviceInstrumentTypeRepository.findAllByInstrumentFirstLevelTypeId(instrumentFirstLevelTypeId);
    }

}
