package com.ljh.farm.entity.vo;

import com.ljh.farm.entity.ProductCenter;
import lombok.Data;

/**
 * @Description
 * @Author rqy
 * @Date 2020/3/11 15:40
 */
@Data
public class ProductCenterVO extends ProductCenter {

    /**
     * 大类名
     */
    private String typeName;
}
