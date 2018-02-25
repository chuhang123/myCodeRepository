package com.mengyunzhi.entity;

import com.fasterxml.jackson.annotation.JsonView;
import com.mengyunzhi.jsonView.NoneJsonView;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by chuhang on 18-2-12
 * 测量范围
 */
@Entity
//@ApiModel(value = "MeasureScale (测量范围)", description = "测量范围实体")
public class MeasureScale implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    //@ApiModelProperty("值")
    private String value;
    //@ApiModelProperty("拼音")
    private String pinyin;
    //@ApiModelProperty("创建时间")
    private Long createTime;
    //@ApiModelProperty("更新时间")
    private Long updateTime;
    @ManyToOne
    //@ApiModelProperty("创建用户")
    private User createUser;

    @ManyToOne
    @JsonView({NoneJsonView.class})
    //@ApiModelProperty("二级器具类别(n : 1)")
    private InstrumentType instrumentType;

    //@ApiModelProperty("一级类别")
    @ManyToOne
    @JsonView({NoneJsonView.class})
    private InstrumentFirstLevelType instrumentFirstLevelType;

    //@ApiModelProperty("权重")
    private int weight = 0;

    @OneToMany
    //@ApiModelProperty("对应的机构授权鉴定项目")
    private Set<DeviceInstrument> deviceInstrumentSet = new HashSet<>();

    public MeasureScale() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getPinyin() {
        return pinyin;
    }

    public void setPinyin(String pinyin) {
        this.pinyin = pinyin;
    }

    public User getCreateUser() {
        return createUser;
    }

    public void setCreateUser(User createUser) {
        this.createUser = createUser;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public InstrumentType getInstrumentType() {
        return instrumentType;
    }

    public void setInstrumentType(InstrumentType instrumentType) {
        this.instrumentType = instrumentType;
    }

    public InstrumentFirstLevelType getInstrumentFirstLevelType() {
        return instrumentFirstLevelType;
    }

    public void setInstrumentFirstLevelType(InstrumentFirstLevelType instrumentFirstLevelType) {
        this.instrumentFirstLevelType = instrumentFirstLevelType;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
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

    public Set<DeviceInstrument> getDeviceInstrumentSet() {
        return deviceInstrumentSet;
    }

    public void setDeviceInstrumentSet(Set<DeviceInstrument> deviceInstrumentSet) {
        this.deviceInstrumentSet = deviceInstrumentSet;
    }
}
