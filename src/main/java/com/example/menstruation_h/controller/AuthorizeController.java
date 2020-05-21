package com.example.menstruation_h.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.menstruation_h.dto.Code2Session;
import com.example.menstruation_h.mapper.UserMapper;
import com.example.menstruation_h.model.User;
import com.example.menstruation_h.util.WXProvide;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class AuthorizeController {
    @Autowired
    WXProvide wxProvide;

    @Autowired
    UserMapper userMapper;

    @Value("${wx.login.appid}")
    String APPID;

    @Value("${wx.login.secret}")
    String SECRET;

    @GetMapping("/onLogin")
    public User onLogin(@RequestParam(name = "code") String code) {
        log.info("code信息，{}", code);
        Code2Session code2Session = wxProvide.auth(APPID, SECRET, code);
        if (code2Session != null && code2Session.getOpenid().length() != 0) {
            QueryWrapper<User> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("openID", code2Session.getOpenid());
            User user = userMapper.selectOne(queryWrapper);
            log.info("user信息,{}",user);
            //初次登陆，插入，设置周期、持续时间
            if (user == null) {
                User newUser = new User();
                newUser.setOpenID(code2Session.getOpenid());
                userMapper.insert(newUser);
                log.info("  初次登陆");
                return newUser;
            }
            else{
                //不是初次登陆，赋值
                return user;
            }


        }

        return null;
    }


}
