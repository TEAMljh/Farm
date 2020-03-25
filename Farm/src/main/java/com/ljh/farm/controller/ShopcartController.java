package com.ljh.farm.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ljh.farm.entity.Shopcart;
import com.ljh.farm.service.ShopcartService;
import com.ljh.farm.util.LayUIResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public Object shopping(String userName) {
        QueryWrapper<Shopcart> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_name", userName).eq("order_flag", '0');
        return LayUIResult.ok(shopcartService.list(queryWrapper));
    }

    @PostMapping("shopping/del/{id}")
    public Object deleteOne(@PathVariable Integer id) {
        if (shopcartService.removeById(id)) {
            return LayUIResult.ok("删除成功");
        } else {
            return LayUIResult.error("删除失败");
        }
    }

    @PostMapping("shopping/bought/{id}")
    public Object bought(@PathVariable Integer id) {
        Shopcart shopcart = shopcartService.getById(id);
        shopcart.setOrderFlag("1");
        if (shopcartService.updateById(shopcart)) {
            return LayUIResult.ok();
        } else {
            return LayUIResult.error();
        }
    }

    @GetMapping("shopcart/changeGoods")
    public Object changeGoods(Integer id) {
        Shopcart shopcart = shopcartService.getById(id);
        if ("0".equals(shopcart.getGoodsFlag())) {
            shopcart.setGoodsFlag("1");
        } else {
            shopcart.setGoodsFlag("0");
        }

        if (shopcartService.updateById(shopcart)) {
            return LayUIResult.ok("状态更新成功");
        } else {
            return LayUIResult.error("状态更新失败");
        }
    }
}
