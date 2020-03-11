package com.ljh.farm.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ljh.farm.entity.ProductCenter;
import com.ljh.farm.entity.vo.ProductCenterVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Description
 * @Author ljh
 * @Date 2020/3/11 15:33
 */
@Mapper
public interface ProductCenterMapper extends BaseMapper<ProductCenter> {

    @Select("select p.id,p.`name`,p.type_id as typeId,m.`name` as typeName from product_center p " +
            "LEFT JOIN max_class m\n" +
            "on m.id=p.type_id where p.type_id=#{typeId}")
    List<ProductCenterVO> list(Integer typeId);
}
