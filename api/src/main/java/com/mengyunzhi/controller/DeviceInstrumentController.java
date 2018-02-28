package com.mengyunzhi.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.mengyunzhi.entity.DeviceInstrument;
import com.mengyunzhi.jsonView.DeviceInstrumentJsonView;
import com.mengyunzhi.repository.DeviceInstrumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.SortDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * Created by chuhang on 18-2-28
 * 装置授权检定项目
 */
@RestController
@RequestMapping("/DeviceInstrument")
public class DeviceInstrumentController {
    @Autowired
    DeviceInstrumentRepository deviceInstrumentRepository;

    @GetMapping("/{id}")
    @JsonView({DeviceInstrumentJsonView.baseJsonView.class})
    public DeviceInstrument get(@PathVariable Long id) {
        return deviceInstrumentRepository.findOne(id);
    }

    @PostMapping("/")
    @JsonView({DeviceInstrumentJsonView.baseJsonView.class})
    public DeviceInstrument save(@RequestBody DeviceInstrument deviceInstrument) {
        return deviceInstrumentRepository.save(deviceInstrument);
    }

    @GetMapping("/pageAllByDeviceSetId/{deviceSetId}")
    @JsonView({DeviceInstrumentJsonView.baseJsonView.class})
    public Page<DeviceInstrument> pageAllByDeviceSetId(@PathVariable Long deviceSetId, @SortDefault
            .SortDefaults(@SortDefault(sort = "id", direction = Sort.Direction.DESC)) Pageable pageable) {
        return deviceInstrumentRepository.findAllByDeviceSetId(deviceSetId, pageable);
    }


    @GetMapping("/pageAll")
    @JsonView({DeviceInstrumentJsonView.baseJsonView.class})
    public Page<DeviceInstrument> pageAll(@SortDefault
            .SortDefaults(@SortDefault(sort = "id", direction = Sort.Direction.DESC)) Pageable pageable) {
        return deviceInstrumentRepository.findAll(pageable);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        deviceInstrumentRepository.delete(id);
        return;
    }

    @PutMapping("/{id}")
    @JsonView({DeviceInstrumentJsonView.baseJsonView.class})
    public DeviceInstrument update(@PathVariable Long id, @RequestBody DeviceInstrument deviceInstrument) {
        deviceInstrument.setId(id);
        return deviceInstrumentRepository.save(deviceInstrument);
    }
}
