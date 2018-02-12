package com.mengyunzhi.dataInit;

import com.mengyunzhi.entity.Discipline;
import com.mengyunzhi.repository.DisciplineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by chuhang on 18-2-12
 */
@Component
public class DisciplineDataInit implements ApplicationListener<ContextRefreshedEvent>, Ordered {
    private static Logger logger = Logger.getLogger(DisciplineDataInit.class.getName());
    @Autowired
    private DisciplineRepository disciplineRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent){
        List<Discipline> disciplinesAll = (List<Discipline>) disciplineRepository.findAll();
        if (disciplinesAll.size() == 0) {
            Integer weight = Ordered.HIGHEST_PRECEDENCE;

            List<Discipline> disciplines = new ArrayList<>();
            Discipline geometricDiscipline = new Discipline();
            geometricDiscipline.setName("长度");
            geometricDiscipline.setPinyin("changdu");
            geometricDiscipline.setWeight(weight++);
            disciplines.add(geometricDiscipline);

            Discipline electromagnetismDiscipline = new Discipline();
            electromagnetismDiscipline.setName("电磁学");
            electromagnetismDiscipline.setPinyin("diancixue");
            electromagnetismDiscipline.setWeight(weight++);
            disciplines.add(electromagnetismDiscipline);

            Discipline chemistryDiscipline = new Discipline();
            chemistryDiscipline.setName("物理化学");
            chemistryDiscipline.setPinyin("wulihuaxue");
            chemistryDiscipline.setWeight(weight++);
            disciplines.add(chemistryDiscipline);

            Discipline temperatureDiscipline = new Discipline();
            temperatureDiscipline.setName("热学");
            temperatureDiscipline.setPinyin("rexue");
            temperatureDiscipline.setWeight(weight++);
            disciplines.add(temperatureDiscipline);

            Discipline electronicsDiscipline = new Discipline();
            electronicsDiscipline.setName("无线电");
            electronicsDiscipline.setPinyin("wuxiandain");
            electronicsDiscipline.setWeight(weight++);
            disciplines.add(electronicsDiscipline);

            Discipline acousticsDiscipline = new Discipline();
            acousticsDiscipline.setName("声学");
            acousticsDiscipline.setPinyin("shengxue");
            acousticsDiscipline.setWeight(weight++);
            disciplines.add(acousticsDiscipline);

            Discipline radiationDiscipline = new Discipline();
            radiationDiscipline.setName("电离辐射");
            radiationDiscipline.setPinyin("dianlifushe");
            radiationDiscipline.setWeight(weight++);
            disciplines.add(radiationDiscipline);

            Discipline opticsDiscipline = new Discipline();
            opticsDiscipline.setName("光学");
            opticsDiscipline.setPinyin("guanxue");
            opticsDiscipline.setWeight(weight++);
            disciplines.add(opticsDiscipline);

            Discipline mechanicsDiscipline = new Discipline();
            mechanicsDiscipline.setName("力学");
            mechanicsDiscipline.setPinyin("lixue");
            mechanicsDiscipline.setWeight(weight++);
            disciplines.add(mechanicsDiscipline);

            Discipline frequencyDiscipline = new Discipline();
            frequencyDiscipline.setName("时间频率");
            frequencyDiscipline.setPinyin("shijianpinlv");
            frequencyDiscipline.setWeight(weight++);
            disciplines.add(frequencyDiscipline);

            disciplineRepository.save(disciplines);
        }
    }

    @Override
    public int getOrder() {
        return HIGHEST_PRECEDENCE;
    }
}

