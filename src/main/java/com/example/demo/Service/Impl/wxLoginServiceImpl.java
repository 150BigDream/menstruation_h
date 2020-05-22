package com.example.demo.Service.Impl;

import com.example.demo.Service.wxLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;

@Service
public class wxLoginServiceImpl implements wxLoginService {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public Object  Login(String name) {
        String sqlName = "select userid from user where openid =?";
        List<Map<String,Object>> id = jdbcTemplate.queryForList(sqlName,name);
        System.out.println(id.get(0).get("userid")+"id*****");
        if(id.size()==0){
            String sql1 = "insert into user(openID,intervalDay,sustainDay)values(?,?,?)";
            System.out.println("name"+name);
            jdbcTemplate.update(sql1,name,0,0);
        }
        return id.get(0).get("userid");
    }

    @Override
    public boolean reLogin(String openID) {
        String sqlRe = "select userid from user where openid =? ";
        List<Map<String,Object>> id = jdbcTemplate.queryForList(sqlRe,openID);
        System.out.println(id.get(0)+"openID是否相等");
        if(id.size()==0){
            System.out.println("该用户没有登陆过");
            return false;//该用户没有登陆过
        }
        else{
            System.out.println("用户登陆过");
             return true;//用户登陆过
             }
    }

    @Override
    public int getUserID(String openID) {
        String sqlGetID = "select userid from user where openid =? ";
      //  int userID = jdbcTemplate.queryForList(sqlGetID,int.class,openID);
        return 0;
    }


}
