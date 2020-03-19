package com.ljh.farm.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ljh.farm.entity.ProductDetail;
import com.ljh.farm.entity.vo.ProductDetailVO;
import com.ljh.farm.mapper.ProductDetailMapper;
import com.ljh.farm.service.ProductDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @Author ljh
 * @Date 2020/3/11 16:39
 */
@Service
public class ProductDetailServiceImpl extends ServiceImpl<ProductDetailMapper, ProductDetail> implements ProductDetailService {

    @Autowired
    private ProductDetailMapper productDetailMapper;

    @Override
    public IPage<ProductDetailVO> pageDetail(IPage iPage, Wrapper wrapper) {
        return productDetailMapper.pageDetail(iPage, wrapper);
    }
}
