package com.ljh.farm.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ljh.farm.entity.ProductCenter;
import com.ljh.farm.entity.vo.ProductCenterVO;
import com.ljh.farm.mapper.ProductCenterMapper;
import com.ljh.farm.service.ProductCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description
 * @Author ljh
 * @Date 2020/3/11 15:34
 */
@Service
public class ProductCenterServiceImpl extends ServiceImpl<ProductCenterMapper, ProductCenter> implements ProductCenterService {

    @Autowired
    private ProductCenterMapper productCenterMapper;

    @Override
    public List<ProductCenterVO> list(Wrapper wrapper) {
        return productCenterMapper.list(wrapper);
    }

    @Override
    public IPage<ProductCenterVO> page(IPage iPage, Wrapper wrapper) {
        return productCenterMapper.page(iPage, wrapper);
    }
}
