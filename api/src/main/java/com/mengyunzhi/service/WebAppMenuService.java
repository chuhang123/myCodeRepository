package com.mengyunzhi.service;

import com.mengyunzhi.entity.WebAppMenu;

import java.util.List;

/**
 * Created by chuhang on 17-12-7
 */
public interface WebAppMenuService {
    //保存
    WebAppMenu save(WebAppMenu webAppMenu);

    //获取所有数据
    List<WebAppMenu> getAll();

    static WebAppMenu getOneWebAppMenu() {
        String randString = CommonService.getRandomStringByLength(10);
        WebAppMenu webAppMenu = new WebAppMenu();
        webAppMenu.setName("测试" + randString);
        webAppMenu.setRouteName("testroute" + randString);
        return webAppMenu;
    }
}
