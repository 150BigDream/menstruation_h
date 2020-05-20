package com.example.menstruation.Controller;

import com.example.menstruation.Bean.Time;
import com.example.menstruation.Service.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller
public class TimeController {
    @Autowired
    TimeService timeService;
    @ResponseBody
    @RequestMapping("/top1")
    public Time find(Integer userid){
        return timeService.findtop1(userid);

    }

    @ResponseBody
    @RequestMapping("/savetime")
    public void saveT(Integer userid){
        Date date=new Date();
        timeService.start(userid,date);
    }
    @ResponseBody
    @RequestMapping("/end")
    public void endT(Integer userid){
        Date date=new Date();
        timeService.end(userid,date);
    }
}
