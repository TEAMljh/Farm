package com.ljh.farm.controller;

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
    public Object productdisplay(@RequestParam(required = false, defaultValue = "1")Integer typeId, QuerySort sort, @RequestParam(required = false, defaultValue = "1") int page,
                                 @RequestParam(required = false, defaultValue = "6") int limit) {
        Page<ProductDetail> poPage = new Page<>(page, limit);
        QueryWrapper<ProductDetail> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("type_id",typeId);
        /*if (StringUtils.isNotEmpty(sort.getSort())) {
            queryWrapper.orderBy(true, "asc".equalsIgnoreCase(sort.getOrder()), sort.getSort());
        }*/
        IPage<ProductDetail> iPage = productDetailService.page(poPage, queryWrapper);
        return LayUIResult.ok(iPage);
//        return new LayUIResult(0,"",iPage.getTotal(),iPage.getRecords());
    }
}
