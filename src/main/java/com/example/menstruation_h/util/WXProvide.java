package com.example.menstruation_h.util;

import com.alibaba.fastjson.JSON;
import com.example.menstruation_h.dto.Code2Session;
import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@Slf4j
public class WXProvide {
    //get请求
    public Code2Session auth(String APPID, String SECRET, String JSCODE) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(" https://api.weixin.qq.com/sns/jscode2session?appid="+APPID+"&secret="+SECRET+"&js_code="+JSCODE+"&grant_type=authorization_code")
                .build();
        try{
            Response response = client.newCall(request).execute();
            String string= response.body().string();
            log.info("json string 的信息,{}",string);//可以看到这里是下划线的
            //将json类型的string转化为一个类对象
            Code2Session code2Session = JSON.parseObject(string, Code2Session.class);
            return code2Session;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
