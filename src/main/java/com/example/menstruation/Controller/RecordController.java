package com.example.menstruation.Controller;

import com.example.menstruation.Service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class RecordController {
    @Autowired
    RecordService recordService;
    @ResponseBody
    @RequestMapping("/savefap")
    public void updatefap(Integer userid,Integer flow,Integer pain){

        recordService.update(userid,flow,pain);
    }
    @ResponseBody
    @RequestMapping("/savehb")
    public void updatehb(Integer userid,String habbits){
        String str=habbits.substring(1,habbits.length()-1);
        String s[]=str.split(",");
        Integer[]habbit=new Integer[5];
      for(int i=0;i<5;i++){
          if(s[i].equals("true"))
              habbit[i]=0;
          else
              habbit[i]=1;
      }

      recordService.updateH(userid,habbit);

    }
}
