package com.example.menstruation_h.service.impl;

import com.example.menstruation_h.model.User;
import com.example.menstruation_h.mapper.UserMapper;
import com.example.menstruation_h.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zz
 * @since 2020-05-19
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
