package com.example.demo.Service;

import java.util.List;
import java.util.Map;

public interface wChartService {
     int [] getDay(String openid,String time);
     int[] getZhexianDay(String openid);
     int getChaDay(int id);
}
