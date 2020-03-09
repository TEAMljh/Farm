package com.ljh.farm.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ljh.farm.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Description
 * @Author ljh
 * @Date 2020/3/9 17:10
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
