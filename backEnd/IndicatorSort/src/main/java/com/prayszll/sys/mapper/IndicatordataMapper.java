package com.prayszll.sys.mapper;

import com.prayszll.sys.entity.Indicatordata;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author prayszll
 * @since 2023-06-21
 */
public interface IndicatordataMapper extends BaseMapper<Indicatordata> {
  List<Indicatordata> getAllData();

}
