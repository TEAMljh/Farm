package com.ljh.farm.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.*;

/**
 * @Description
 * @Author ljh
 * @Date 2020/3/19 14:47
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = false)
public class ImgSuffix extends Base {

    @TableField("suffix_name")
    private String suffixName;
}
