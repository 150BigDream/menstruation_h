package com.example.menstruation_h.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.menstruation_h.mapper.TimeMapper;
import com.example.menstruation_h.mapper.UserMapper;
import com.example.menstruation_h.model.Time;
import com.example.menstruation_h.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 * <p>
 * 设置自定义的姨妈持续时间和间隔
 * </p>
 *
 * @author zz
 * @since 2020-05-19
 */
@RestController
@Slf4j
public class SubmitController {

    @Autowired
    UserMapper userMapper;

    @Autowired
    TimeMapper timeMapper;

    @GetMapping("/submit")
    public String submit(@RequestParam(name = "lastStart") String lastStart,
                         @RequestParam(name = "fsustainDay") int fsustainDay,
                         @RequestParam(name = "fintervalDay") int fintervalDay,
                         @RequestParam(name = "openID") String openID
    ) {
        User user = userMapper.selectOne(new QueryWrapper<User>().eq("openID", openID));
        user.setFsustainDay(fsustainDay);
        user.setFintervalDay(fintervalDay);
        userMapper.updateById(user);

        LocalDate lastStart2 = LocalDate.parse(lastStart, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        log.info("lastStart ,{}",lastStart);

        int userID=user.getUserID();
        Time time = new Time();
        time.setUserID(userID);
        time.setStartTime(lastStart2);

        long interval=LocalDate.now().until(lastStart2, ChronoUnit.DAYS);
        log.info("今天和上一次姨妈开始时间的间隔interval,{}",interval);

        if (interval>=fsustainDay){
            time.setEndTime(lastStart2.plusDays(fsustainDay));
        }
        timeMapper.insert(time);
        return "ok";
    }

}
