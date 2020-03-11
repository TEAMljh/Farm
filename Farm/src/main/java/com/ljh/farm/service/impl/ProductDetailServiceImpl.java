package com.ljh.farm.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ljh.farm.entity.ProductDetail;
import com.ljh.farm.mapper.ProductDetailMapper;
import com.ljh.farm.service.ProductDetailService;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @Author ljh
 * @Date 2020/3/11 16:39
 */
@Service
public class ProductDetailServiceImpl extends ServiceImpl<ProductDetailMapper, ProductDetail> implements ProductDetailService {
}
