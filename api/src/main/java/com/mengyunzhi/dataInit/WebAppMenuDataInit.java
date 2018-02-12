package com.mengyunzhi.dataInit;

import com.mengyunzhi.entity.WebAppMenu;
import com.mengyunzhi.repository.WebAppMenuRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by chuhang on 17-12-6
 * 前台菜单数据初始化
 */
@Component
public class WebAppMenuDataInit implements ApplicationListener<ContextRefreshedEvent>, Ordered {
    private Logger logger = Logger.getLogger(WebAppMenuDataInit.class.getName());
    @Autowired
    private WebAppMenuRepository webAppMenuRepository; // 前台菜单
    // 前台菜单
    protected Set<WebAppMenu> webAppMenus = new HashSet<>();

    // 权重
    protected int weight = 0;

    private WebAppMenu mainMenu;
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

        List<WebAppMenu> webAppMenusAll = webAppMenuRepository.findAll();
        if (webAppMenusAll.size() == 0) {
            mainMenu = new WebAppMenu();
            mainMenu.setAbstract(true);
            mainMenu.setTemplateUrl("views/main.html");
            mainMenu.setShow(false);
            mainMenu.setName("首页");
            mainMenu.setRouteName("main");
            mainMenu.setDescription("系统主界面");
            mainMenu.setWeight(weight++);
            webAppMenus.add(mainMenu);

            logger.info("标准装置管理");
            this.addWebAppMenuStandard();

            logger.info("系统设置");
            this.addWebAppMenuSystem();

            logger.info("个人中心");
            this.addWebAppMenuPersonalCenter();

            webAppMenuRepository.save(webAppMenus);

        }
    }

    // 技术机构
    protected void addWebAppMenuStandard() {
        WebAppMenu standardMenu = new WebAppMenu();
        standardMenu.setAbstract(true);
        standardMenu.setRouteName("standard");
        standardMenu.setWeight(weight++);
        standardMenu.setName("标准装置管理");
        standardMenu.setDescription("标准装置管理");
        webAppMenus.add(standardMenu);

        WebAppMenu standardFileMenu = new WebAppMenu();
        standardFileMenu.setRouteName("File");
        standardFileMenu.setParentRouteWebAppMenu(standardMenu);
        standardFileMenu.setParentWebAppMenu(standardMenu);
        standardFileMenu.setName("综合查询");
        standardFileMenu.setDescription("标准装置的综合查询");
        standardFileMenu.setWeight(weight++);
        webAppMenus.add(standardFileMenu);

        WebAppMenu deviceSetManageMenu = new WebAppMenu();
        deviceSetManageMenu.setRouteName("deviceSetManage");
        deviceSetManageMenu.setParentRouteWebAppMenu(standardMenu);
        deviceSetManageMenu.setParentWebAppMenu(standardMenu);
        deviceSetManageMenu.setName("档案管理");
        deviceSetManageMenu.setDescription("标准装置的信息管理");
        deviceSetManageMenu.setWeight(weight++);
        webAppMenus.add(deviceSetManageMenu);

        WebAppMenu standardAuthorizationManageMenu = new WebAppMenu();
        standardAuthorizationManageMenu.setRouteName("FileDeviceInstrument");
        standardAuthorizationManageMenu.setParentRouteWebAppMenu(standardMenu);
        standardAuthorizationManageMenu.setParentWebAppMenu(standardMenu);
        standardAuthorizationManageMenu.setName("授权检定项目管理");
        standardAuthorizationManageMenu.setWeight(weight++);
        standardAuthorizationManageMenu.setDescription("授权检定项目的信息管理");
        webAppMenus.add(standardAuthorizationManageMenu);
    }

    // 个人中心
    protected void addWebAppMenuPersonalCenter() {
        WebAppMenu personalCenterMenu = new WebAppMenu();
        personalCenterMenu.setName("个人中心");
        personalCenterMenu.setWeight(weight++);
        personalCenterMenu.setDescription("个人中心");
        personalCenterMenu.setRouteName("system.Personal");
        webAppMenus.add(personalCenterMenu);
    }

    // 系统设置
    protected void addWebAppMenuSystem() {
        WebAppMenu systemConfigMenu = new WebAppMenu();
        systemConfigMenu.setName("系统设置");
        systemConfigMenu.setAbstract(true);
        systemConfigMenu.setRouteName("system");
        systemConfigMenu.setWeight(weight++);
        systemConfigMenu.setDescription("系统设置");
        webAppMenus.add(systemConfigMenu);

        WebAppMenu userMenu = new WebAppMenu();
        userMenu.setName("用户管理");
        userMenu.setRouteName("Userfile");
        userMenu.setDescription("用户信息管理");
        userMenu.setParentRouteWebAppMenu(systemConfigMenu);
        userMenu.setParentWebAppMenu(systemConfigMenu);
        userMenu.setWeight(weight++);
        userMenu.setShow(false);
        webAppMenus.add(userMenu);

        WebAppMenu roleMenu = new WebAppMenu();
        roleMenu.setName("角色管理");
        roleMenu.setDescription("角色信息管理");
        roleMenu.setRouteName("role");
        roleMenu.setWeight(weight++);
        roleMenu.setParentWebAppMenu(systemConfigMenu);
        roleMenu.setParentRouteWebAppMenu(systemConfigMenu);
        webAppMenus.add(roleMenu);

        WebAppMenu systemMenuMenu = new WebAppMenu();
        systemMenuMenu.setName("菜单管理");
        systemMenuMenu.setDescription("菜单信息查询");
        systemMenuMenu.setRouteName("Menu");
        systemMenuMenu.setWeight(weight++);
        systemMenuMenu.setParentRouteWebAppMenu(systemConfigMenu);
        systemMenuMenu.setParentWebAppMenu(systemConfigMenu);
        webAppMenus.add(systemMenuMenu);

        logger.info("增加标准器具类别路由");
        WebAppMenu standardInstrumentTypeMenu = new WebAppMenu();
        standardInstrumentTypeMenu.setName("标准器类别管理");
        standardInstrumentTypeMenu.setDescription("标准器类别的信息管理");
        standardInstrumentTypeMenu.setRouteName("standardInstrumentType");
        standardInstrumentTypeMenu.setWeight(weight++);
        standardInstrumentTypeMenu.setParentWebAppMenu(systemConfigMenu);
        standardInstrumentTypeMenu.setParentRouteWebAppMenu(systemConfigMenu);
        webAppMenus.add(standardInstrumentTypeMenu);
    }


    @Override
    public int getOrder() {
        return HIGHEST_PRECEDENCE;
    }

}
