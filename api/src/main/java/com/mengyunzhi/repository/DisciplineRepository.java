package com.mengyunzhi.repository;

import com.mengyunzhi.entity.Discipline;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by chuhang on 18-2-12
 * 学科
 */
public interface DisciplineRepository extends PagingAndSortingRepository<Discipline, Long> {
}
