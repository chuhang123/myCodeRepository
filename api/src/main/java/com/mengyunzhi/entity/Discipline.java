package com.mengyunzhi.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by chuhang on 18-2-12
 */
@Entity
//@ApiModel(value = "Discipline (学科)", description = "学科实体")
public class Discipline implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    //@ApiModelProperty("名称")
    private String name = "";
    //@ApiModelProperty("拼音")
    private String pinyin;

    //@ApiModelProperty("权重，越小越靠前")
    private Integer weight;


    public Discipline() {
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

    public static long getSerialVersionUID() {

        return serialVersionUID;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }
}
