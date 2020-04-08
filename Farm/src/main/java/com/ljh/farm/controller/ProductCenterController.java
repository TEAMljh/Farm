package com.ljh.farm.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ljh.farm.entity.vo.ProductCenterVO;
import com.ljh.farm.service.ProductCenterService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author rqy
 * @Date 2020/3/11 15:35
 */
@RestController
@RequestMapping("main")
public class ProductCenterController {

    @Autowired
    private ProductCenterService productCenterService;

    @GetMapping("/productcenter/list")
    public Object list(Integer typeId) {
        QueryWrapper<ProductCenterVO> queryWrapper = new QueryWrapper<>();
        return productCenterService.listCenter(queryWrapper.eq("type_id", typeId).eq("p.del_flag",'0'));
    }
}
