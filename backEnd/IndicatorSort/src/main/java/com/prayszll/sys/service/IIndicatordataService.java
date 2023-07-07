package com.prayszll.sys.service;

import com.prayszll.sys.entity.Indicatordata;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author prayszll
 * @since 2023-06-21
 */
public interface IIndicatordataService extends IService<Indicatordata> {
    List<Indicatordata> getAllData();

//    List<Indicatordata> getAllData();
}
