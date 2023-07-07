package com.prayszll.sys.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.prayszll.common.vo.Result;
import com.prayszll.sys.entity.Indicatordata;
import com.prayszll.sys.entity.Menu;
import com.prayszll.sys.entity.Role;
import com.prayszll.sys.service.IIndicatordataService;
import com.prayszll.sys.service.IMenuService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
//import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.List;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
/**
 * <p>
 *  前端控制器
 * </p>
 */
@RestController
@RequestMapping("indicatorall")
public class IndicatordataController {
    @Autowired
    private IIndicatordataService indicatordataService;

    @ApiOperation("查询所有指标数据")
    @GetMapping
    public Result<List<Indicatordata>> getAllData(){
        List<Indicatordata> roleList = indicatordataService.list();
        return Result.success(roleList);
    }
//    @GetMapping
//    public List<Indicatordata> getAllUsers() {
//        return indicatordataService.getAllData();
//    }

}
