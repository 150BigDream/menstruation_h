package com.example.menstruation.Service;

import com.example.menstruation.Bean.Time;

import java.util.Date;

public interface TimeService {
    void start(Integer userid, Date start);
    void end(Integer userid, Date end);
    Time findtop1(Integer userid);
}
