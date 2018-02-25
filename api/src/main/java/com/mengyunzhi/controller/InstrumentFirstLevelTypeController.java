package com.mengyunzhi.controller;

import com.mengyunzhi.entity.InstrumentFirstLevelType;
import com.mengyunzhi.repository.InstrumentFirstLevelTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by chuhang on 18-2-23
 */
@RestController
@RequestMapping("/InstrumentFirstLevelType")
public class InstrumentFirstLevelTypeController {
    @Autowired
    InstrumentFirstLevelTypeRepository instrumentFirstLevelTypeRepository;

    @GetMapping("/getAllByDisciplineId/{disciplineId}")
    public Iterable<InstrumentFirstLevelType> getAllByDisciplineId(@PathVariable Long disciplineId) {
        return instrumentFirstLevelTypeRepository.findAllByDisciplineId(disciplineId);
    }

    @PostMapping("/")
    public InstrumentFirstLevelType save(@RequestBody InstrumentFirstLevelType instrumentFirstLevelType) {
        return instrumentFirstLevelTypeRepository.save(instrumentFirstLevelType);
    }
}
