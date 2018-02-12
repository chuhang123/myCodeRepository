package com.mengyunzhi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by chuhang on 18-2-12
 * 精度实体
 */
@Entity
//@ApiModel(value = "Accuracy 精度实体", description = "等级准确度示值偏差的值")
public class Accuracy implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    //@ApiModelProperty("精度值")
    private String value = "";
    //@ApiModelProperty("拼音")
    private String pinyin = "";
    @ManyToOne
    //@ApiModelProperty("操作用户")
    private User createUser;

    //@ApiModelProperty("二级类别(n:1)")
    @ManyToOne
    private InstrumentType instrumentType;

    //@ApiModelProperty("权重")
    private int weight = 0;

    //@ApiModelProperty("是否已删除")
    @JsonIgnore
    private Boolean deleted = false;

    public Accuracy() {
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

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
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

    public User getCreateUser() {
        return createUser;
    }

    public void setCreateUser(User createUser) {
        this.createUser = createUser;
    }
    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public String getPinyin() {
        return pinyin;
    }

    public void setPinyin(String pinyin) {
        this.pinyin = pinyin;
    }

}
