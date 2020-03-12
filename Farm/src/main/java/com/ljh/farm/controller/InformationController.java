package com.ljh.farm.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ljh.farm.entity.Information;
import com.ljh.farm.service.InformationService;
import com.ljh.farm.util.LayUIResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author ljh
 * @Date 2020/3/11 17:47
 */
@RestController
@RequestMapping("main")
public class InformationController {

    @Autowired
    private InformationService informationService;

    @GetMapping("news/list")
    public Object news(@RequestParam(required = false, defaultValue = "1") int page,
                       @RequestParam(required = false, defaultValue = "3") int limit) {
        Page<Information> poPage = new Page<>(page, limit);
        QueryWrapper<Information> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderBy(true, false, "create_time");
        IPage<Information> iPage = informationService.page(poPage, queryWrapper);
        return LayUIResult.ok(iPage);
    }
}
