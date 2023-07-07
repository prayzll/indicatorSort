package com.prayszll.sys.mapper;

import com.prayszll.sys.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 */
public interface UserMapper extends BaseMapper<User> {

    public List<String> getRoleNameByUserId(Integer userId);
}
