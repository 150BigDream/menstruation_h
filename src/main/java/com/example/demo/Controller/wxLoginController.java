package com.example.demo.Controller;

import com.example.demo.Service.wxLoginService;
import com.example.demo.Util.HttpRequest;
import com.example.demo.entity.wxUser;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RestController
public class wxLoginController {
    @Resource
    wxLoginService  wxLoginService;
    @Autowired
    com.example.demo.Service.wChartService wChartService;

    @RequestMapping("/cis")//这个是获得code的值
    public Object getcode(@RequestParam(value = "code")String  code, Model model) throws Exception {
        String appId = "wxe6412f91b5b4cee5";        // 小程序的secret
        String appsecret = "1cfde1bbe8d978dad2b38e65396ca2ca";         //向微信服务器 使用登录凭证 code 获取 session_key 和 openid        // 请求参数
        String params = "appid=" + appId + "&secret=" + appsecret + "&js_code=" + code + "&grant_type=authorization_code";
        String sr = HttpRequest.sendGet("https://api.weixin.qq.com/sns/jscode2session", params);// 发送请求        String sr = HttpRequest.sendGet("https://api.weixin.qq.com/sns/jscode2session", params);
        JSONObject jsonObject1 =JSONObject.fromObject(sr);
        Object openid = jsonObject1.get("openid");
        System.out.println(String.valueOf(openid)+"是否为空");
        wxLoginService.Login(String.valueOf(openid));//没有重复的openID才进行插入
        model.addAttribute(openid);
        return openid;
    }

    @RequestMapping("/reLogin")
    public int reLogin(@RequestParam(value = "openid") String openID) {
        System.out.println(openID+"openid");
        if (wxLoginService.reLogin(openID)){
            System.out.println(1+"进来了");
            return 1;//该用户登陆过
             }
        else{
            System.out.println(0+"进来了");
            return 0;//该用户没有登陆过
        }

    }
//    @RequestMapping("/name")//这个是获得name
//    public void getName(@RequestParam(value = "name") String name){
//          System.out.println("被调用");
//          System.out.println("name"+name);
//         wxLoginService.Login(name);
//    }
}
