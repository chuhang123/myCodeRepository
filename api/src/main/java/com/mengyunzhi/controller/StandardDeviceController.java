package com.mengyunzhi.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.mengyunzhi.entity.StandardDevice;
import com.mengyunzhi.jsonView.StandardDeviceJsonView;
import com.mengyunzhi.repository.StandardDeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * Created by chuhang on 18-2-27
 * 标准器
 */
@RestController
@RequestMapping("/StandardDevice")
public class StandardDeviceController {
    @Autowired
    StandardDeviceRepository standardDeviceRepository;

    @GetMapping("/{id}")
    @JsonView({StandardDeviceJsonView.baseJsonView.class})
    public StandardDevice get(@PathVariable Long id) {
        return standardDeviceRepository.findOne(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        standardDeviceRepository.delete(id);
        return;
    }

    @PostMapping("/")
    @JsonView({StandardDeviceJsonView.baseJsonView.class})
    public StandardDevice save(@RequestBody StandardDevice standardDevice) {
        return standardDeviceRepository.save(standardDevice);
    }

    @PutMapping("/{id}")
    @JsonView({StandardDeviceJsonView.baseJsonView.class})
    public StandardDevice update(@PathVariable Long id, @RequestBody StandardDevice standardDevice) {
        standardDevice.setId(id);
        return standardDeviceRepository.save(standardDevice);
    }

    @GetMapping("/getStandardDevicesByDeviceSetId/{deviceSetId}")
    @JsonView({StandardDeviceJsonView.baseJsonView.class})
    public Iterable<StandardDevice> getStandardDevicesByDeviceSetId(@PathVariable Long deviceSetId) {
        return standardDeviceRepository.findAllByDeviceSetId(deviceSetId);
    }
}
