package com.ljh.farm.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ljh.farm.entity.Information;
import com.ljh.farm.mapper.InformationMapper;
import com.ljh.farm.service.InformationService;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @Author ljh
 * @Date 2020/3/11 17:46
 */
@Service
public class InformationServiceImpl extends ServiceImpl<InformationMapper, Information> implements InformationService {
}
