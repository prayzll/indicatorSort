package com.prayszll.sys.service;

import com.prayszll.sys.entity.Menu;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 */
public interface IMenuService extends IService<Menu> {

    List<Menu> getAllMenu();

    List<Menu> getMenuListByUserId(Integer userId);
}
