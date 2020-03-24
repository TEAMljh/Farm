package com.ljh.farm.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

/**
 * @Description
 * @Author ljh
 * @Date 2020/3/9 17:06
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = false)
@TableName("user")
public class User extends Base{

    @TableField("name")
    private String name;

    @TableField("pass")
    private String pass;

    @TableField("province")
    private String province;

    @TableField("city")
    private String city;

    @TableField("county")
    private String county;

    @TableField("detail")
    private String detail;

    @TableField("tel")
    private String tel;
}
