package com.mengyunzhi.repository;

import com.mengyunzhi.entity.Discipline;
import com.mengyunzhi.entity.InstrumentFirstLevelType;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by chuhang on 18-2-23
 * 器具一级类别
 */
public interface InstrumentFirstLevelTypeRepository extends PagingAndSortingRepository<InstrumentFirstLevelType, Long> {
    Iterable<InstrumentFirstLevelType> findAllByDisciplineId(Long disciplineId);
}
