package com.ljh.farm.controller;

import com.ljh.farm.entity.Shopcart;
import com.ljh.farm.service.ShopcartService;
import com.ljh.farm.util.LayUIResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author ljh
 * @Date 2020/3/13 16:31
 */
@RestController
@RequestMapping("main")
public class ShopcartController {

    @Autowired
    private ShopcartService shopcartService;

    @GetMapping("shopcart")
    public Object shopcart(Shopcart shopcart) {
        if (shopcartService.save(shopcart)) {
            return LayUIResult.ok("添加成功");
        } else {
            return LayUIResult.error("添加失败");
        }
    }

    @GetMapping("shopping")
    public Object shopping() {

        return LayUIResult.ok(shopcartService.list());
    }
}
