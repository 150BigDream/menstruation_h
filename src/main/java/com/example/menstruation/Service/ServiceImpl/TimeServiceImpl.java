package com.example.menstruation.Service.ServiceImpl;

import com.example.menstruation.Bean.Time;
import com.example.menstruation.Repository.TimeRepository;
import com.example.menstruation.Service.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class TimeServiceImpl implements TimeService {
    @Autowired
    TimeRepository timeRepository;
    Map<Integer,Integer> map=new HashMap<Integer, Integer>();
    public void start(Integer userid, Date start){
        Time time=new Time();
        time.setUserid(userid);
        time.setStartTime(start);
        System.out.println(time.getId());
        timeRepository.save(time);

        map.put(userid,time.getId());
    }

    @Override
    public void end(Integer userid, Date end) {
        Integer id=map.get(userid);
        timeRepository.updateTime(end,id);

    }

    @Override
    public Time findtop1(Integer userid) {
        Time time=timeRepository.findTop1(userid);
//        System.out.println(time.getStartTime());
        return time;
    }

}
