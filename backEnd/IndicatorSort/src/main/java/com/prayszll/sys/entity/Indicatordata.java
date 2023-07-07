package com.prayszll.sys.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 
 * </p>
 *
 * @author prayszll
 * @since 2023-06-21
 */
public class Indicatordata implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "IndicatorID", type = IdType.AUTO)
    private Integer indicatorID;

    @TableField("indicatorName")
    private String indicatorName;

    @TableField("indicatorUnit")
    private String indicatorUnit;

    public Integer getIndicatorID() {
        return indicatorID;
    }

    public void setIndicatorID(Integer indicatorID) {
        this.indicatorID = indicatorID;
    }
    public String getIndicatorName() {
        return indicatorName;
    }

    public void setIndicatorName(String indicatorName) {
        this.indicatorName = indicatorName;
    }
    public String getIndicatorUnit() {
        return indicatorUnit;
    }

    public void setIndicatorUnit(String indicatorUnit) {
        this.indicatorUnit = indicatorUnit;
    }

    @Override
    public String toString() {
        return "Indicatordata{" +
            "indicatorID=" + indicatorID +
            ", indicatorName=" + indicatorName +
            ", indicatorUnit=" + indicatorUnit +
        "}";
    }
    @TableField(exist = false)
    private List<Monitoring> monitorings;
}
