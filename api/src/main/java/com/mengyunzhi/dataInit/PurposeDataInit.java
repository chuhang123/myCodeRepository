package com.mengyunzhi.dataInit;

import com.mengyunzhi.entity.Purpose;
import com.mengyunzhi.repository.PurposeRepository;
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
 * 用途
 */
@Component
public class PurposeDataInit implements ApplicationListener<ContextRefreshedEvent>, Ordered {
    private static Logger logger = Logger.getLogger(PurposeDataInit.class.getName());

    @Autowired
    private PurposeRepository purposeRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent)
    {
        List<Purpose> purposes = (List<Purpose>) purposeRepository.findAll();
        if (purposes.size() == 0) {
            List<Purpose> purposes1 = new ArrayList<>();

            Purpose purpose = new Purpose();
            purpose.setName("贸易结算");
            purpose.setPinyin("maoyijiesuan");
            purposes1.add(purpose);

            Purpose purpose1 = new Purpose();
            purpose1.setName("安全防护");
            purpose1.setPinyin("anquangfanghu");
            purposes1.add(purpose1);

            Purpose purpose2 = new Purpose();
            purpose2.setName("医疗卫生");
            purpose2.setPinyin("yiliaoweisheng");
            purposes1.add(purpose2);

            Purpose purpose3 = new Purpose();
            purpose3.setPinyin("huangjingjiance");
            purpose3.setName("环境监测");
            purposes1.add(purpose3);

            Purpose purpose4 = new Purpose();
            purpose4.setName("行政执法");
            purpose4.setPinyin("xingzhengzhifa");
            purposes1.add(purpose4);

            Purpose purpose5 = new Purpose();
            purpose5.setName("司法鉴定");
            purpose5.setPinyin("sifajianding");
            purposes1.add(purpose5);

            purposeRepository.save(purposes1);
        }
    }

    @Override
    public int getOrder() {
        return HIGHEST_PRECEDENCE;
    }
}

