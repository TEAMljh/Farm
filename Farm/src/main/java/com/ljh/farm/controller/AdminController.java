package com.ljh.farm.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ljh.farm.entity.ProductCenter;
import com.ljh.farm.entity.ProductDetail;
import com.ljh.farm.entity.vo.ProductCenterVO;
import com.ljh.farm.service.ProductCenterService;
import com.ljh.farm.service.ProductDetailService;
import com.ljh.farm.util.LayUIResult;
import com.ljh.farm.util.QuerySort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Description
 * @Author ljh
 * @Date 2020/3/17 17:02
 */
@RestController
@RequestMapping("admin")
public class AdminController {

    @Autowired
    private ProductCenterService productCenterService;

    @Autowired
    private ProductDetailService productDetailService;

    @GetMapping("productMaintain/page")
    public Object listProductType(QuerySort sort, @RequestParam(required = false, defaultValue = "1") int page,
                                  @RequestParam(required = false, defaultValue = "10") int limit) {
        Page<ProductCenterVO> voPage = new Page<>(page, limit);
        QueryWrapper<ProductCenterVO> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("p.del_flag", '0');
        IPage<ProductCenterVO> iPage = productCenterService.page(voPage, queryWrapper);
        return new LayUIResult(0, "", iPage.getTotal(), iPage.getRecords());
    }

    @PostMapping("productMaintain/del/{id}")
    public Object deleteProductType(@PathVariable Integer id) {
        if (productCenterService.removeById(id)) {
            return LayUIResult.ok("删除成功");
        } else {
            return LayUIResult.error("删除失败");
        }
    }

    @GetMapping("productMaintain/addOrUpdate")
    public Object addOrUpdate(ProductCenter productCenter) {
        if (productCenter.getId() == null) {
            if (productCenterService.save(productCenter)) {
                return LayUIResult.ok("添加成功");
            } else {
                return LayUIResult.error("添加失败");
            }
        }
        if (productCenterService.updateById(productCenter)) {
            return LayUIResult.ok("修改成功");
        } else {
            return LayUIResult.error("修改失败");
        }
    }


    @GetMapping("product/page")
    public Object pageProduct(QuerySort sort, @RequestParam(required = false, defaultValue = "1") int page,
                              @RequestParam(required = false, defaultValue = "10") int limit) {
        Page<ProductDetail> poPage = new Page<>(page, limit);
        QueryWrapper<ProductDetail> queryWrapper = new QueryWrapper<>();
        IPage<ProductDetail> iPage = productDetailService.page(poPage, queryWrapper);
        return new LayUIResult(0, "", iPage.getTotal(), iPage.getRecords());
    }
}
