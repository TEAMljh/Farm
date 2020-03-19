package com.ljh.farm.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.ljh.farm.entity.ProductDetail;
import com.ljh.farm.entity.vo.ProductDetailVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @Description
 * @Author ljh
 * @Date 2020/3/11 16:38
 */
@Mapper
public interface ProductDetailMapper extends BaseMapper<ProductDetail> {
    @Select("SELECT\n" +
            "\tpd.id,\n" +
            "\tpd.`name`,\n" +
            "\tpd.img,\n" +
            "\tpd.pri,\n" +
            "\tpd.old_pri AS oldPri,\n" +
            "\tpd.discount,\n" +
            "\tpd.single,\n" +
            "\tpd.img_detail AS imgDetail,\n" +
            "\tpd.create_time AS createTime,\n" +
            "\tpd.type_id AS typeId,\n" +
            "\tpc.`name` AS typeName,\n" +
            "\tpd.del_flag AS delFlag \n" +
            "FROM\n" +
            "\tproduct_detail pd\n" +
            "\tLEFT JOIN product_center pc ON pd.type_id = pc.id ${ew.customSqlSegment}")
    IPage<ProductDetailVO> pageDetail(IPage iPage, @Param(Constants.WRAPPER) Wrapper wrapper);
}
