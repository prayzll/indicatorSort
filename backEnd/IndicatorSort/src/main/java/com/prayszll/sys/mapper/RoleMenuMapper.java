package com.prayszll.sys.mapper;

import com.prayszll.sys.entity.RoleMenu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 */
public interface RoleMenuMapper extends BaseMapper<RoleMenu> {
    public List<Integer> getMenuIdListByRoleId(Integer roleId);
}
