package com.ljh.farm.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;

import java.io.Serializable;

/**
 * @Description
 * @Author ljh
 * @Date 2020/3/12 8:46
 */
@Data
public abstract class Base implements Serializable {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 逻辑删除标志
     */
    @TableLogic
    private String delFlag;
}
