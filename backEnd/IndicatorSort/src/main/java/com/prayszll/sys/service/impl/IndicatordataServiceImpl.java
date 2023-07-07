package com.prayszll.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.prayszll.sys.entity.Indicatordata;
import com.prayszll.sys.entity.Menu;
import com.prayszll.sys.mapper.IndicatordataMapper;
import com.prayszll.sys.service.IIndicatordataService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author prayszll
 * @since 2023-06-21
 */
@Service
public class IndicatordataServiceImpl extends ServiceImpl<IndicatordataMapper, Indicatordata> implements IIndicatordataService {
    private IndicatordataMapper indicatordataMapper;
    @Override
    public List<Indicatordata> getAllData() {
        LambdaQueryWrapper<Indicatordata> wrapper = new LambdaQueryWrapper<>();
        List<Indicatordata> indicatorList = this.list(wrapper);
        return indicatorList;
    }

//    public Indicatordata getAllData(Integer id){
//        return indicatordataMapper.getAllData(id);
//    }

//    @Override
//    public List<Indicatordata> getAllIndicator() {
//        LambdaQueryWrapper<Indicatordata> wrapper = new LambdaQueryWrapper<>();
//        wrapper.eq(Indicatordata::getIndicatorID,0);
//        List<Indicatordata> indicatordataList = this.list(wrapper);
//        System.out.println("zll+:" +indicatordataList);
//        return indicatordataList;
//    }
}
