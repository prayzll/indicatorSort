package com.prayszll.sys.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
//import com.prayszll.sys.entity.Indicatordata;
import com.prayszll.sys.entity.Monitoring;
//import com.prayszll.sys.mapper.IndicatordataMapper;
import com.prayszll.sys.mapper.MonitoringMapper;
import com.prayszll.sys.service.IMonitoringService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 */
@Service
public class MonitoringServiceImpl extends ServiceImpl<MonitoringMapper, Monitoring> implements IMonitoringService {
    private MonitoringMapper monitoringMapper;
//    public List<Monitoring> getAllMonitor() {
//        return monitoringMapper.getAllMonitor();
//    }

    public List<Monitoring> getJoin() {
        return monitoringMapper.getJoin();
    }
    @Override
    public void addData(Monitoring monitoring) {
        this.baseMapper.insert(monitoring);
    }

    @Override
    public Monitoring getDataById(Integer id) {
        Monitoring monitoring = this.baseMapper.selectById(id);
        return monitoring;
    }

    @Override
    public void updateData(Monitoring monitoring) {
        this.baseMapper.updateById(monitoring);
    }

    @Override
    public void deleteDataById(Integer id) {
        this.baseMapper.deleteById(id);
    }


}
