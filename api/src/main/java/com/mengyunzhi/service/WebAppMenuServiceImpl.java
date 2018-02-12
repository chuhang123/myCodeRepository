package com.mengyunzhi.service;

import com.mengyunzhi.entity.WebAppMenu;
import com.mengyunzhi.repository.WebAppMenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chuhang on 17-12-7
 */
@Service
public class WebAppMenuServiceImpl implements WebAppMenuService {
    @Autowired
    private WebAppMenuRepository webAppMenuRepository;

    @Override
    public WebAppMenu save(WebAppMenu webAppMenu) {
        webAppMenuRepository.save(webAppMenu);
        return webAppMenu;
    }

    @Override
    public List<WebAppMenu> getAll() {
        List<WebAppMenu> list = new ArrayList<WebAppMenu>();
        // 按权重进行排序，权重越小越靠前
        list = (List<WebAppMenu>)webAppMenuRepository.findAll(new Sort("weight"));
        return list;
    }
}