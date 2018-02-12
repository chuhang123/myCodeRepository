package com.mengyunzhi.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.io.Serializable;

/**
 * Created by chuhang on 18-2-12
 * 标准器类别
 */
@Entity
//@ApiModel("StandardDeviceInstrumentType 标准器类别")
@DiscriminatorValue("StandardDevice")
public class StandardDeviceInstrumentType extends InstrumentType implements Serializable {
    private static final long serialVersionUID = 1L;
}
