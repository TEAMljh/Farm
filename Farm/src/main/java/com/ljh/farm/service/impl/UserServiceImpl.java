package com.ljh.farm.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ljh.farm.entity.User;
import com.ljh.farm.mapper.UserMapper;
import com.ljh.farm.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @Author ljh
 * @Date 2020/3/9 17:11
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
