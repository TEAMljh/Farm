package com.ljh.farm.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ljh.farm.entity.ProductDetail;
import com.ljh.farm.service.ProductDetailService;
import com.ljh.farm.util.LayUIResult;
import com.ljh.farm.util.QuerySort;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Description
 * @Author ljh
 * @Date 2020/3/11 16:40
 */
@RestController
@RequestMapping("main")
public class ProductDetailController {

    @Autowired
    private ProductDetailService productDetailService;

    @GetMapping("productdisplay/list")
    public Object productdisplay(@RequestParam(required = false, defaultValue = "1") Integer typeId, QuerySort sort, @RequestParam(required = false, defaultValue = "1") int page,
                                 @RequestParam(required = false, defaultValue = "6") int limit) {
        Page<ProductDetail> poPage = new Page<>(page, limit);
        QueryWrapper<ProductDetail> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderBy(true, false, "create_time").eq("type_id", typeId);
        /*if (StringUtils.isNotEmpty(sort.getSort())) {
            queryWrapper.orderBy(true, "asc".equalsIgnoreCase(sort.getOrder()), sort.getSort());
        }*/
        IPage<ProductDetail> iPage = productDetailService.page(poPage, queryWrapper);
        return LayUIResult.ok(iPage);
//        return new LayUIResult(0,"",iPage.getTotal(),iPage.getRecords());
    }

    @GetMapping("today")
    public Object today(@RequestParam(required = false, defaultValue = "1") int page,
                        @RequestParam(required = false, defaultValue = "8") int limit) {

//        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
//        System.out.println(df.format(new Date()));
//        String date=df.format(new Date());
        Page<ProductDetail> poPage = new Page<>(page, limit);
        QueryWrapper<ProductDetail> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderBy(true, false, "create_time");
        IPage<ProductDetail> iPage = productDetailService.page(poPage, queryWrapper);
        return LayUIResult.ok(iPage);
    }

    @GetMapping("productdisplay")
    public Object getProduct(Integer id) {

        return productDetailService.getById(id);
    }

    @GetMapping("productdisplay/all")
    public Object productdisplayAll(String name, @RequestParam(required = false, defaultValue = "1") int page,
                                    @RequestParam(required = false, defaultValue = "6") int limit) {
        Page<ProductDetail> poPage = new Page<>(page, limit);
        QueryWrapper<ProductDetail> queryWrapper = new QueryWrapper<>();
//        queryWrapper.orderBy(true, false, "create_time").eq("type_id", typeId);
        LambdaQueryWrapper<ProductDetail> lambdaQueryWrapper = queryWrapper.lambda();
        // 根据名称搜索
        if (StringUtils.isNotEmpty(name)) {
            lambdaQueryWrapper.like(ProductDetail::getName, name);
        }
        IPage<ProductDetail> iPage = productDetailService.page(poPage, queryWrapper);
        return LayUIResult.ok(iPage);
//        return new LayUIResult(0,"",iPage.getTotal(),iPage.getRecords());
    }
}
