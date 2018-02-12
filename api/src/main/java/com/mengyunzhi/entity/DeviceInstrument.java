package com.mengyunzhi.entity;

import com.fasterxml.jackson.annotation.JsonView;
import org.hibernate.annotations.Immutable;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by chuhang on 18-2-12
 * 装置授权检定项目
 */
@Entity
@Immutable
//@ApiModel(value = "DeviceInstrument (装置授权检定项目)", description = "装置授权检定项目实体")
public class DeviceInstrument implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    //@ApiModelProperty("器具二级类别")
    private InstrumentType instrumentType;

    @ManyToOne
    //@ApiModelProperty("计量标准装置")
    private DeviceSet deviceSet;

    @ManyToOne
    //@ApiModelProperty("对应的最小测量范围")        //关联测量范围
    private MeasureScale minMeasureScale;

    @ManyToOne
    //@ApiModelProperty("对应的最大测量范围")        //关联测量范围
    private MeasureScale maxMeasureScale;

    @ManyToOne
    //@ApiModelProperty("对应的精度")         //关联精度
    private Accuracy accuracy;

    public DeviceInstrument() {
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public InstrumentType getInstrumentType() {
        return instrumentType;
    }

    public void setInstrumentType(InstrumentType instrumentType) {
        this.instrumentType = instrumentType;
    }

    public DeviceSet getDeviceSet() {
        return deviceSet;
    }

    public void setDeviceSet(DeviceSet deviceSet) {
        this.deviceSet = deviceSet;
    }

    public MeasureScale getMinMeasureScale() {
        return minMeasureScale;
    }

    public void setMinMeasureScale(MeasureScale minMeasureScale) {
        this.minMeasureScale = minMeasureScale;
    }

    public Accuracy getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(Accuracy accuracy) {
        this.accuracy = accuracy;
    }

    public MeasureScale getMaxMeasureScale() {
        return maxMeasureScale;
    }

    public void setMaxMeasureScale(MeasureScale maxMeasureScale) {
        this.maxMeasureScale = maxMeasureScale;
    }
}

