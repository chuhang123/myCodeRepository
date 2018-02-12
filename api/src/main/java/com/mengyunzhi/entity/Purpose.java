package com.mengyunzhi.entity;

import javax.persistence.*;

/**
 * Created by chuhang on 18-2-12
 * 用途
 */
@Entity
//@ApiModel(value = "Purpose (用途)", description = "每个器具使用信息对应的用途")
public class Purpose {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    //@ApiModelProperty("名称")
    private String name = null;
    //@ApiModelProperty("拼音")
    private String pinyin = null;
    //@ApiModelProperty("创建时间")
    private Long createTime;
    //@ApiModelProperty("更新时间")
    private Long updateTime;
    //@ApiModelProperty("添加用途的用户")
    @ManyToOne
    private User createUser;

    public Purpose() {
    }

    public Purpose(String name, String pinyin, Long createTime, Long updateTime, User createUser) {
        this.name = name;
        this.pinyin = pinyin;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.createUser = createUser;
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

    public User getCreateUser() {
        return createUser;
    }

    public void setCreateUser(User createUser) {
        this.createUser = createUser;
    }

    @Override
    public String toString() {
        return "Purpose{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pinyin='" + pinyin + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", createUser=" + createUser +
                '}';
    }
}

