package com.example.demo.Service.Impl;

import com.example.demo.Service.wChartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
    public class wChartServiceImpl implements wChartService {
        @Autowired
        private JdbcTemplate jdbcTemplate;
        public int getID(String openid){
            String Sqlid ="select userid from user where openid = ?";
            int id = jdbcTemplate.queryForObject(Sqlid,int.class,openid);
            return id;
        }
        @Override
        public int[]  getDay(String openid,String time) {
           int id = getID(openid);
            System.out.println(id+"此时id");
            int [] dateTime = new int[5];
            String sqlTime = "select count(*) from record where userid1=? and drinkWater=1 and MONTH(time) =?";
            int water=jdbcTemplate.queryForObject(sqlTime,int.class,id,time);
            dateTime[0] = water;
            String sqlTime1 = "select count(*) from record where userid1=? and exercise=1 and MONTH(time) =?";
            int exercise=jdbcTemplate.queryForObject(sqlTime1,int.class,id,time);
            dateTime[1] = exercise;
            String sqlTime2 = "select count(*) from record where userid1=? and earlyToBed=1 and MONTH(time) =?";
            int earlyToBed=jdbcTemplate.queryForObject(sqlTime2,int.class,id,time);
            dateTime[2] = earlyToBed;
            String sqlTime3 = "select count(*) from record where userid1=? and eatBreakfast=1 and MONTH(time) =?";
            int eatBreakfast=jdbcTemplate.queryForObject(sqlTime3,int.class,id,time);
            dateTime[3] = eatBreakfast;
            String sqlTime4 = "select count(*) from record where userid1=? and reading=1 and MONTH(time) =?";
            int reading=jdbcTemplate.queryForObject(sqlTime4,int.class,id,time);
            dateTime[4] = reading;
            System.out.println("water"+water+"exercise"+exercise+"earlyToBed"+earlyToBed+"eatBreakfast"
                    +eatBreakfast+"reading"+reading);
            return dateTime;
        }

        @Override
        public int [] getZhexianDay(String openid) {
            int id = getID(openid);
            String sqlZheTime = "SELECT DATEDIFF(endTime,startTime) AS DiffDate from time where userid=?";
            List list = new ArrayList();
            list=jdbcTemplate.queryForList(sqlZheTime,int.class,id);
            int [] re = new int[list.size()];
            System.out.println(">>>>>>>");
            System.out.println(list);
            for(int i =0;i<list.size();i++){
                re[i] = Integer.parseInt(String.valueOf( list.get(i)));
                System.out.println(re[i]);
            }
            return re;
        }

    @Override
    public int getChaDay(int id) {
            return 0;

    }

}


