package com.ljh.farm.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.util.Date;

/**
 * @Description
 * @Author ljh
 * @Date 2020/3/11 16:28
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = false)
@TableName("product_detail")
public class ProductDetail {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("name")
    private String name;

    @TableField("img")
    private String img;

    @TableField("pri")
    private Integer pri;

    @TableField("old_pri")
    private Integer oldPri;

    @TableField("discount")
    private String discount;

    @TableField("single")
    private String single;

    @TableField("img_detail")
    private String imgDetail;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GTM-8")
    @TableField("creat_time")
    private Date creatTime;

    @TableField("type_id")
    private Integer typeId;
}
