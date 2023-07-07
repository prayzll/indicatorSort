package com.prayszll.sys.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.prayszll.common.vo.Result;
import com.prayszll.sys.entity.Indicatordata;
import com.prayszll.sys.entity.Monitoring;
import com.prayszll.sys.entity.Role;
import com.prayszll.sys.entity.User;
import com.prayszll.sys.service.IMonitoringService;
import io.swagger.annotations.Api;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author prayszll
 * @since 2023-06-21
 */
@Api(tags = {"数据接口列表"})
@RestController
@RequestMapping("indicator")
public class MonitoringController {
    @Autowired
    private IMonitoringService monitoringService;
    @GetMapping("/list")
    public Result<Map<String,Object>> getDataList(@RequestParam(value = "taskName",required = false) String taskName,
                                                  @RequestParam(value = "pageNo") Long pageNo,
                                                  @RequestParam(value = "pageSize") Long pageSize){

        LambdaQueryWrapper<Monitoring> wrapper = new LambdaQueryWrapper<>();

//        LambdaQueryWrapper<Indicatordata> wrap = new LambdaQueryWrapper<>();
        wrapper.eq(StringUtils.hasLength(taskName),Monitoring::getTaskName,taskName);

        wrapper.orderByDesc(Monitoring::getIndicatorValue);

        Page<Monitoring> page = new Page<>(pageNo,pageSize);
        monitoringService.page(page,wrapper);

        Map<String,Object> data = new HashMap<>();
        data.put("total",page.getTotal());
        data.put("rows",page.getRecords());

        return Result.success(data);

    }

    @PostMapping
    public Result<?> addData(@RequestBody Monitoring monitoring){
        monitoringService.addData(monitoring);
        return Result.success("新增成功");
    }

    @PutMapping
    public Result<?> updateData(@RequestBody Monitoring monitoring){
        monitoringService.updateData(monitoring);
        return Result.success("修改成功");
    }

    @GetMapping("/{id}")
    public Result<Monitoring> getDataById(@PathVariable("id") Integer id){
        Monitoring monitoring = monitoringService.getDataById(id);
        return Result.success(monitoring);
    }

    @DeleteMapping("/{id}")
    public Result<Monitoring> deleteDataById(@PathVariable("id") Integer id){
        monitoringService.deleteDataById(id);
        return Result.success("删除角色成功");
    }

    @GetMapping("/all")
//    @Select("select * from monitoring")
    public Result<List<Monitoring>> getAllRole(){
        List<Monitoring> roleList = monitoringService.list();
        return Result.success(roleList);
    }

//    @GetMapping("/join")
//    public List<Monitoring> getJoin() {
//        return monitoringService.getJoin();
//    }
}
