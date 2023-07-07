package com.prayszll.sys.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.prayszll.sys.entity.Monitoring;
import com.baomidou.mybatisplus.extension.service.IService;
import com.prayszll.sys.entity.User;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author prayszll
 * @since 2023-06-21
 */
public interface IMonitoringService extends IService<Monitoring> {

//    List<Map<String, Object>> getDataList(String taskName, Page<Map<String, Object>> page);

    void addData(Monitoring monitoring);

    Monitoring getDataById(Integer id);

    void updateData(Monitoring monitoring);

    void deleteDataById(Integer id);


    List<Monitoring> getJoin();
}
