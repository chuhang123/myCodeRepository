package com.mengyunzhi.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.mengyunzhi.entity.DeviceSet;
import com.mengyunzhi.jsonView.DeviceSetJsonView;
import com.mengyunzhi.repository.DeviceSetRepository;
import com.mengyunzhi.service.DeviceSetService;
import com.mengyunzhi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * Created by chuhang on 18-2-25
 * 计量标准装置
 */
@RestController
@RequestMapping("/DeviceSet")
public class DeviceSetController {
    @Autowired
    DeviceSetRepository deviceSetRepostiory;
    @Autowired
    UserService userService;
    @Autowired
    DeviceSetService deviceSetService;

    @GetMapping("")
    @JsonView({DeviceSetJsonView.baseJsonView.class})
    public Page<DeviceSet> pageAll(@SortDefault.SortDefaults(@SortDefault(sort = "id", direction = Sort.Direction.DESC)) Pageable pageable) {
        return deviceSetRepostiory.findAll(pageable);
    }

    @GetMapping("/{id}")
    @JsonView({DeviceSetJsonView.baseJsonView.class})
    public DeviceSet get(@PathVariable Long id) {
        return deviceSetRepostiory.findOne(id);
    }

    @PostMapping("/")
    @JsonView({DeviceSetJsonView.baseJsonView.class})
    public DeviceSet save(@RequestBody DeviceSet deviceSet) {
        return deviceSetRepostiory.save(deviceSet);
    }

    @PutMapping("/{id}")
    @JsonView({DeviceSetJsonView.baseJsonView.class})
    public DeviceSet update(@PathVariable Long id, @RequestBody DeviceSet deviceSet) {
        deviceSet.setId(id);
        return deviceSetRepostiory.save(deviceSet);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        deviceSetRepostiory.delete(id);
        return;
    }

    @GetMapping("/pageAllBySpecification")
    @JsonView({DeviceSetJsonView.baseJsonView.class})
    public Page<DeviceSet> pageAllBySpecification(
            @RequestParam(name = "name", required = false) String name,
            @RequestParam(name = "code", required = false) String code,
            @PageableDefault(sort = {"id"}, direction = Sort.Direction.DESC) Pageable pageable) {

        return deviceSetService.pageAllBySpecification(name, code, pageable);
    }
}
