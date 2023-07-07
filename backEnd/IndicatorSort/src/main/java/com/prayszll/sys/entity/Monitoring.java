package com.prayszll.sys.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

/**
 * <p>
 * 
 * </p>
 *
 * @author prayszll
 * @since 2023-06-21
 */
@Data
@TableName("monitoring")
@AllArgsConstructor
@NoArgsConstructor
public class Monitoring implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "TaskID", type = IdType.AUTO)
    private Integer taskID;
    @TableField("taskName")
    private String taskName;
    @TableField("indicatorID")
    private Integer indicatorID;
    @TableField("indicatorValue")
    private Float indicatorValue;
    @TableField("indicatorTime")
    private LocalDate indicatorTime;

    public Integer getTaskID() {
        return taskID;
    }

    public void setTaskID(Integer taskID) {
        this.taskID = taskID;
    }
    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }
    public Integer getIndicatorID() {
        return indicatorID;
    }

    public void setIndicatorID(Integer indicatorID) {
        this.indicatorID = indicatorID;
    }
    public Float getIndicatorValue() {
        return indicatorValue;
    }

    public void setIndicatorValue(Float indicatorValue) {
        this.indicatorValue = indicatorValue;
    }
    public LocalDate getIndicatorTime() {
        return indicatorTime;
    }

    public void setIndicatorTime(LocalDate indicatorTime) {
        this.indicatorTime = indicatorTime;
    }

    @Override
    public String toString() {
        return "Monitoring{" +
            "taskID=" + taskID +
            ", taskName=" + taskName +
            ", indicatorID=" + indicatorID +
            ", indicatorValue=" + indicatorValue +
            ", indicatorTime=" + indicatorTime +
        "}";
    }
    @TableField(exist = false)
    private List<Integer> monitorList;
}
