package com.mengyunzhi.entity;

import org.springframework.context.annotation.Lazy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by chuhang on 17-12-6
 * 角色实体
 */
@Entity
public class Role implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    ////@ApiModelProperty("名称")
    @Column(unique = true)
    private String name;
    ////@ApiModelProperty("用户名拼音")
    private String pinyin;
    ////@ApiModelProperty("是否系统管理员")
    private boolean isAdmin = false;
    ////@ApiModelProperty("创建时间")
    private Long createTime;
    ////@ApiModelProperty("更新时间")
    private Long updateTime;

    ////@ApiModelProperty("该角色下的所有菜单")
    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(
            name = "menu_role",
            joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "menu_id")
    )
    private Set<Menu> menus = new HashSet<Menu>();

    ////@ApiModelProperty("对应的前台菜单")
    @ManyToMany
    @Lazy
    @JoinTable(
            name = "web_app_menu_role",
            joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "web_app_menu_id")
    )
    private Set<WebAppMenu> webAppMenus = new HashSet<WebAppMenu>();

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public Role() {
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pinyin='" + pinyin + '\'' +
                ", isAdmin=" + isAdmin +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", menus=" + menus +
                ", webAppMenus=" + webAppMenus +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPinyin() {
        return pinyin;
    }

    public void setPinyin(String pinyin) {
        this.pinyin = pinyin;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }

    public Set<Menu> getMenus() {
        return menus;
    }

    public void setMenus(Set<Menu> menus) {
        this.menus = menus;
    }

    public Set<WebAppMenu> getWebAppMenus() {
        return webAppMenus;
    }

    public void setWebAppMenus(Set<WebAppMenu> webAppMenus) {
        this.webAppMenus = webAppMenus;
    }

    public void addWebAppMenu(WebAppMenu webAppMenu) {
        this.webAppMenus.add(webAppMenu);
    }
}
