package com.example.menstruation_h.service.impl;

import com.example.menstruation_h.model.Time;
import com.example.menstruation_h.mapper.TimeMapper;
import com.example.menstruation_h.service.TimeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zz
 * @since 2020-05-20
 */
@Service
public class TimeServiceImpl extends ServiceImpl<TimeMapper, Time> implements TimeService {

}
