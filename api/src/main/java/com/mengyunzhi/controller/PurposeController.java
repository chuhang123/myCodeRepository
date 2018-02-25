package com.mengyunzhi.controller;

import com.mengyunzhi.entity.Purpose;
import com.mengyunzhi.repository.PurposeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by chuhang on 18-2-23
 * 用途
 */
@RequestMapping("/Purpose")
@RestController
public class PurposeController {
    @Autowired
    PurposeRepository purposeRepository;

    @GetMapping("/getAll")
    public Iterable<Purpose> get() {
        return purposeRepository.findAll();
    }
}
