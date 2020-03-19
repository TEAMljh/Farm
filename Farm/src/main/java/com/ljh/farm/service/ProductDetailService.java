package com.ljh.farm.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ljh.farm.entity.ProductDetail;
import com.ljh.farm.entity.vo.ProductDetailVO;

/**
 * @Description
 * @Author ljh
 * @Date 2020/3/11 16:39
 */
public interface ProductDetailService extends IService<ProductDetail> {
    IPage<ProductDetailVO> pageDetail(IPage iPage, Wrapper wrapper);
}
