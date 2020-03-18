package com.ljh.farm.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ljh.farm.entity.ProductCenter;
import com.ljh.farm.entity.ProductDetail;
import com.ljh.farm.entity.User;
import com.ljh.farm.entity.vo.ProductCenterVO;
import com.ljh.farm.service.MaxClassService;
import com.ljh.farm.service.ProductCenterService;
import com.ljh.farm.service.ProductDetailService;
import com.ljh.farm.service.UserService;
import com.ljh.farm.util.LayUIResult;
import com.ljh.farm.util.QuerySort;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @Autowired
    private MaxClassService maxClassService;

    @Autowired
    private UserService userService;

    @GetMapping("user/page")
    public Object userPage(User user, QuerySort sort, @RequestParam(required = false, defaultValue = "1") int page,
                           @RequestParam(required = false, defaultValue = "10") int limit) {
        Page<User> poPage = new Page<>(page, limit);
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        LambdaQueryWrapper<User> lambdaQueryWrapper = queryWrapper.lambda();
        if (StringUtils.isNotEmpty(user.getName())) {
            lambdaQueryWrapper.like(User::getName, user.getName());
        }
        if (StringUtils.isNotEmpty(user.getDetail())) {
            lambdaQueryWrapper.like(User::getDetail, user.getDetail());
        }
        IPage<User> iPage = userService.page(poPage, lambdaQueryWrapper);
        return new LayUIResult(0, "", iPage.getTotal(), iPage.getRecords());
    }

    @GetMapping("productMaintain/page")
    public Object listProductType(ProductCenterVO productCenterVO, QuerySort sort, @RequestParam(required = false, defaultValue = "1") int page,
                                  @RequestParam(required = false, defaultValue = "10") int limit) {
        Page<ProductCenterVO> voPage = new Page<>(page, limit);
        QueryWrapper<ProductCenterVO> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("p.del_flag", '0');
        LambdaQueryWrapper<ProductCenterVO> lambdaQueryWrapper = queryWrapper.lambda();
        if (StringUtils.isNotEmpty(productCenterVO.getTypeName())) {
            lambdaQueryWrapper.like(ProductCenterVO::getTypeName, productCenterVO.getTypeName());
        }
        IPage<ProductCenterVO> iPage = productCenterService.pageCenter(voPage, lambdaQueryWrapper);
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

    @GetMapping("productMaintain/list")
    public Object listMaintain() {
        return LayUIResult.ok(maxClassService.list());
    }


    @GetMapping("product/page")
    public Object pageProduct(ProductDetail productDetail, QuerySort sort, @RequestParam(required = false, defaultValue = "1") int page,
                              @RequestParam(required = false, defaultValue = "10") int limit) {
        Page<ProductDetail> poPage = new Page<>(page, limit);
        QueryWrapper<ProductDetail> queryWrapper = new QueryWrapper<>();
        LambdaQueryWrapper<ProductDetail> lambdaQueryWrapper = queryWrapper.lambda();
        if (StringUtils.isNotEmpty(productDetail.getName())) {
            lambdaQueryWrapper.like(ProductDetail::getName, productDetail.getName());
        }
        if (productDetail.getTypeId()!=null) {
            lambdaQueryWrapper.eq(ProductDetail::getTypeId, productDetail.getTypeId());
        }
        IPage<ProductDetail> iPage = productDetailService.page(poPage, lambdaQueryWrapper);
        return new LayUIResult(0, "", iPage.getTotal(), iPage.getRecords());
    }

    @PostMapping("product/del/{id}")
    public Object delProduct(@PathVariable Integer id) {
        if (productDetailService.removeById(id)) {
            return LayUIResult.ok("删除成功");
        } else {
            return LayUIResult.error("删除失败");
        }
    }

    @GetMapping("product/addOrUpdate")
    public Object addOrUpdateProducDetail(ProductDetail productDetail) {
        if (productDetail.getId() != null) {
            if (productDetailService.save(productDetail)) {
                return LayUIResult.ok("添加成功");
            } else {
                return LayUIResult.error("添加失败");
            }
        }
        if (productDetailService.updateById(productDetail)) {
            return LayUIResult.ok("修改成功");
        } else {
            return LayUIResult.error("修改失败");
        }
    }

    @GetMapping("product/list")
    public Object listProducType() {
        return LayUIResult.ok(productCenterService.list());
    }
}
