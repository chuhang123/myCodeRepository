package com.mengyunzhi.controller;

import com.mengyunzhi.entity.Discipline;
import com.mengyunzhi.repository.DisciplineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by chuhang on 18-2-12
 * 学科类别
 */
@RequestMapping("/Discipline")
@RestController
public class DisciplineController {
    @Autowired
    DisciplineRepository disciplineRepository;

    @GetMapping("")
    public Iterable<Discipline> getAll() {
        return disciplineRepository.findAll();
    }
}
