package com.ljh.farm.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

/**
 * @Description
 * @Author ljh
 * @Date 2020/3/11 15:26
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = false)
@TableName("product_center")
public class ProductCenter extends Base{

    @TableField("name")
    private String name;

    @TableField("type_id")
    private Integer typeId;
}
