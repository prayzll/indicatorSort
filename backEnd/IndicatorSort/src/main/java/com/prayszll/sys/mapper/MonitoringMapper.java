package com.prayszll.sys.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.prayszll.sys.entity.Monitoring;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.lettuce.core.dynamic.annotation.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author prayszll
 * @since 2023-06-21
 */
public interface MonitoringMapper extends BaseMapper<Monitoring> {

    List<Map<String, Object>> getDataList(@Param("taskName") String taskName, @Param("pageNo") Long pageNo, @Param("pageSize") Long pageSize);

//    List<Map<String, Object>> getDataList(String taskName, Page<Map<String, Object>> page);
    List<Monitoring> getAllMonitor();
    List<Monitoring> getJoin();
}
