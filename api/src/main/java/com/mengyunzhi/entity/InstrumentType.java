package com.mengyunzhi.entity;

import com.fasterxml.jackson.annotation.JsonView;
import com.mengyunzhi.jsonView.DeviceInstrumentJsonView;
import com.mengyunzhi.jsonView.NoneJsonView;
import com.mengyunzhi.jsonView.StandardDeviceInstrumentTypeJsonView;
import com.mengyunzhi.jsonView.StandardDeviceJsonView;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by chuhang on 18-2-12
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) // Inheritance = 继承
@DiscriminatorColumn(name = "table_type")
//@ApiModel(value = "InstrumentType (器具类别)", description = "器具类别实体")
public class InstrumentType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    //@ApiModelProperty("名称")
    private String name = "";
    //@ApiModelProperty("拼音")
    private String pinyin = "";
    //@ApiModelProperty("创建时间")
    private Long createTime;
    //@ApiModelProperty("更新时间")
    private Long updateTime;
    @ManyToOne
    //@ApiModelProperty("用户")
    private User CreateUser;

    //@ApiModelProperty("器具一级类别")
    @ManyToOne
    @JsonView({NoneJsonView.class,
            StandardDeviceInstrumentTypeJsonView.baseJsonView.class,
            DeviceInstrumentJsonView.baseJsonView.class,
            StandardDeviceJsonView.baseJsonView.class})
    private InstrumentFirstLevelType instrumentFirstLevelType;

    //@ApiModelProperty("等级准确度示值偏差显示名称")
    @ManyToOne
    private AccuracyDisplayName accuracyDisplayName;

    // 参照hibernate实战第七章第三节级联状态
    @OneToMany(mappedBy = "instrumentType", cascade = {CascadeType.REFRESH, CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE}, orphanRemoval = true)
    //@ApiModelProperty("oneToMany 规格型号")
    @JsonView({NoneJsonView.class,
            StandardDeviceInstrumentTypeJsonView.baseJsonView.class})
    private Set<Specification> specifications = new HashSet<>();

    @ManyToMany
    //@ApiModelProperty("用途")
    @JoinTable(
            name = "instrument_type_purposes",
            joinColumns = @JoinColumn(name = "instrument_type_id"),
            inverseJoinColumns = @JoinColumn(name = "purpose_id"))
    @JsonView({NoneJsonView.class,
            StandardDeviceInstrumentTypeJsonView.baseJsonView.class})
    private Set<Purpose> purposes = new HashSet<>();

    //@ApiModelProperty("oneToMany精度")
    @OneToMany(mappedBy = "instrumentType", cascade = {CascadeType.ALL})
    @JsonView({NoneJsonView.class,
            StandardDeviceInstrumentTypeJsonView.baseJsonView.class})
    private Set<Accuracy> accuracies = new HashSet<>();

    //@ApiModelProperty("测量范围 @ManyToMany")
    @OneToMany(mappedBy = "instrumentType", cascade = {CascadeType.ALL})
    @JsonView({NoneJsonView.class,
            StandardDeviceInstrumentTypeJsonView.baseJsonView.class})
    private Set<MeasureScale> measureScales = new HashSet<>();

    public InstrumentType() {
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Set<Purpose> getPurposes() {
        return purposes;
    }

    public void setPurposes(Set<Purpose> purposes) {
        this.purposes = purposes;
    }

    public void addPurpose(Purpose purpose) {
        this.purposes.add(purpose);
    }

    public Set<Accuracy> getAccuracies() {
        return accuracies;
    }

    public void setAccuracies(Set<Accuracy> accuracies) {
        this.accuracies = accuracies;
    }

    public void addAccuracy(Accuracy accuracy) {
        this.accuracies.add(accuracy);
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
        return CreateUser;
    }

    public void setCreateUser(User createUser) {
        CreateUser = createUser;
    }

    public InstrumentFirstLevelType getInstrumentFirstLevelType() {
        return instrumentFirstLevelType;
    }

    public void setInstrumentFirstLevelType(InstrumentFirstLevelType instrumentFirstLevelType) {
        this.instrumentFirstLevelType = instrumentFirstLevelType;
    }

    public AccuracyDisplayName getAccuracyDisplayName() {
        return accuracyDisplayName;
    }

    public void setAccuracyDisplayName(AccuracyDisplayName accuracyDisplayName) {
        this.accuracyDisplayName = accuracyDisplayName;
    }


    public void addSpcification(Specification specification) {
        this.specifications.add(specification);
    }

    public Set<Specification> getSpecifications() {
        return specifications;
    }

    public void setSpecifications(Set<Specification> specifications) {
        this.specifications = specifications;
    }

    public Set<MeasureScale> getMeasureScales() {
        return measureScales;
    }

    public void setMeasureScales(Set<MeasureScale> measureScales) {
        this.measureScales = measureScales;
    }

    public void addMeasureScale(MeasureScale measureScale) {
        this.measureScales.add(measureScale);
    }
}
