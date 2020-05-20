package com.example.demo.Controller;
import com.example.demo.Util.CalenderJudge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class wxController {

    @Autowired
    com.example.demo.Service.wChartService wChartService;

    @RequestMapping("/day")
    public Map<String ,Object> getDay(@RequestParam(value = "time") String time ,@RequestParam(value = "openid") String openid,Model model){
        System.out.println(time.substring(5,7)+"time");
        int []countTime = wChartService.getDay(openid,time.substring(5,7));
        int Maxtime=countTime[0];
        for(int i=1;i<countTime.length;i++){
            if(Maxtime<countTime[i])
                Maxtime = countTime[i];
        }
        Map<String,Object> map= new HashMap<String,Object>();
        map.put("day1",30);//本月的生理周期是多少天
        map.put("day2",Maxtime);//本月好习惯记录是多少天
        map.put("吃早餐",countTime[3]);
        map.put("锻炼",countTime[1]);
        map.put("阅读",countTime[4]);
        map.put("早睡",countTime[2]);
        map.put("喝水",countTime[0]);
        model.addAttribute(map);
        return map;
    }
    @RequestMapping("/bing")
    public int [] getBing(@RequestParam(value = "time") String time ,Model model,@RequestParam(value = "openid") String openid){
        CalenderJudge calenderJudge = new CalenderJudge();
        int [] num = new int[6];
        int []numRes = wChartService.getDay(openid,time.substring(5,7));
        num[0] =calenderJudge.judegeDay(new Date());
        for(int i=1;i<num.length;i++){
            num[i] = numRes [i-1];
        }
        model.addAttribute(num);
        return num;
    }
    @RequestMapping("/zhexian")
    public int [] getZhexian(Model model, HttpServletRequest request,@RequestParam(value = "openid") String openid){
      int [] num = wChartService.getZhexianDay(openid);
      int j=0;
      int [] numN = new int[6];
          if(num.length>6){
          for(int i=num.length-6;i<num.length;i++){
              numN[j] =num[i];
              j++;
          }
          num = numN;
          }
        model.addAttribute(num);
        return num;
    }
}
