package com.mengyunzhi.controller;

import com.mengyunzhi.entity.AccuracyDisplayName;
import com.mengyunzhi.repository.AccuracyDisplayNameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by chuhang on 18-2-23
 */
@RestController
@RequestMapping("/AccuracyDisplayName")
public class AccuracyDisplayNameController {
    @Autowired
    AccuracyDisplayNameRepository accuracyDisplayNameRepository;

    @GetMapping("/getAll")
    public Iterable<AccuracyDisplayName> getAll() {
        return accuracyDisplayNameRepository.findAll();
    }
}
