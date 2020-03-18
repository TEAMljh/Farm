package com.ljh.farm.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.ljh.farm.entity.ProductCenter;
import com.ljh.farm.entity.vo.ProductCenterVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
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
            "on m.id=p.type_id ${ew.customSqlSegment}")
    List<ProductCenterVO> listCenter(@Param(Constants.WRAPPER) Wrapper wrapper);

    @Select("select p.id,p.`name`,p.type_id as typeId,p.del_flag as delFlag,m.`name` as typeName from product_center p " +
            "LEFT JOIN max_class m\n" +
            "on m.id=p.type_id ${ew.customSqlSegment}")
    IPage<ProductCenterVO> pageCenter(IPage iPage, @Param(Constants.WRAPPER) Wrapper wrapper);
}
