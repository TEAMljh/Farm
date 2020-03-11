package com.ljh.farm.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ljh.farm.entity.ProductCenter;
import com.ljh.farm.entity.vo.ProductCenterVO;

import java.util.List;

/**
 * @Description
 * @Author rqy
 * @Date 2020/3/11 15:34
 */
public interface ProductCenterService extends IService<ProductCenter> {
    List<ProductCenterVO> list(Integer typeId);
}
