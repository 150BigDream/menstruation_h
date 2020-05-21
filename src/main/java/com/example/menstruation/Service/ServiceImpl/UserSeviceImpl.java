package com.example.menstruation.Service.ServiceImpl;

import com.example.menstruation.Bean.Time;
import com.example.menstruation.Bean.User;
import com.example.menstruation.Repository.TimeRepository;
import com.example.menstruation.Repository.UserRepository;
import com.example.menstruation.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserSeviceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    TimeRepository timeRepository;
    @Override
    public User find(Integer userid) {
       User user=userRepository.findByUserID(userid);
       return user;
    }

    @Override
    public void updateDate(Integer userid) {
//        List<Time> list=timeRepository.findByUserid(userid);
//        long sumSus=0,sumInter=0;
//        long betweenDays;
//        long betweenDays1;
//        for(int i=0;i<list.size();i++){
//            Date start=list.get(i).getStartTime();
//            Date end=list.get(i).getEndTime();
//            betweenDays = (end.getTime() - start.getTime()) / (1000L*3600L*24L);
//            sumSus+=betweenDays;
//            if(i<list.size()-1){
//            Date start1=list.get(i+1).getStartTime();
//            betweenDays1 = (start1.getTime() - start.getTime()) / (1000L*3600L*24L);
//            sumInter+=betweenDays1;
//            }
//        }
//        Integer fSus=(int) sumSus/list.size();
//        Integer fInter=(int)sumInter/(list.size()-1);
        User user=userRepository.findByUserID(userid);
        Integer count=timeRepository.countAllByUserid(userid);
        long betweenDays;
        long betweenDays1;
        Integer fSus=0,fInter=0;
        if(count>=2){
            List<Time> list=timeRepository.findTop2(userid);
            Date start=list.get(0).getStartTime();
            Date end=list.get(0).getEndTime();
            betweenDays = (end.getTime() - start.getTime()) / (1000L*3600L*24L);
            Date start1=list.get(1).getStartTime();
            betweenDays1 = (start.getTime() - start1.getTime()) / (1000L*3600L*24L);
            double d=Math.rint((user.getFsustainDay()*(count-1)+betweenDays)/(count*1.0));
            double d1=Math.rint((user.getFintervalDay()*(count-1)+betweenDays1)/(count*1.0));
            fSus=(int)d;
            fInter=(int)d1;
            userRepository.updateDate(userid,fSus,fInter);
        }

    }


}
