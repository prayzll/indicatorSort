package com.prayszll.sys.mapper;

import com.prayszll.sys.entity.Menu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 */
public interface MenuMapper extends BaseMapper<Menu> {
    public List<Menu> getMunuListByUserId(@Param("userId") Integer userId, @Param("pid") Integer pid);
}
