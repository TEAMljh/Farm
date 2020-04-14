package com.ljh.farm.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

/**
 * @Description
 * @Author ljh
 * @Date 2020/3/13 16:27
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = false)
@TableName("shopcart")
public class Shopcart extends Base {

    @TableField("img")
    private String img;

    @TableField("title")
    private String title;

    @TableField("single")
    private String single;

    @TableField("pri")
    private Double pri;

    @TableField("num")
    private Integer num;

    @TableField("user_name")
    private String userName;

    @TableField("user_tel")
    private String userTel;

    @TableField("user_address")
    private String userAddress;

    @TableField("order_flag")
    private String orderFlag;

    @TableField("goods_flag")
    private String goodsFlag;
}
