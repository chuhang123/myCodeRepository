package com.mengyunzhi.repository;

import com.mengyunzhi.entity.StandardDeviceInstrumentType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

/**
 * Created by chuhang on 18-2-12
 * 标准器类别
 */
public interface StandardDeviceInstrumentTypeRepository extends PagingAndSortingRepository<StandardDeviceInstrumentType, Long> {
    @Query("select m from #{#entityName} m where m.instrumentFirstLevelType.discipline.id = :disciplineId")
    Page<StandardDeviceInstrumentType> pageByDisciplineId(@Param("disciplineId") Long disciplineId, Pageable pageable);

    @Query("select m from #{#entityName} m where m.instrumentFirstLevelType.discipline.id = :disciplineId")
    Iterable<StandardDeviceInstrumentType> getAllByDisciplineId(@Param("disciplineId") Long disciplineId);

    Iterable<StandardDeviceInstrumentType> findAllByInstrumentFirstLevelTypeId(Long id);
}
