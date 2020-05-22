package com.example.menstruation.Controller;

import com.example.menstruation.Bean.User;
import com.example.menstruation.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;


@Controller
public class UserController {
   @Autowired
    UserService userService;
    @RequestMapping("/user")
    @ResponseBody
    public User rhello(Integer userid){

        return userService.find(userid);
    }
    @RequestMapping("/updatef")
    @ResponseBody
    public void upadteUser(Integer userid){
        userService.updateDate(userid);
    }
    @RequestMapping("/hello")
    @ResponseBody
    public String he(){
       return "1111";
    }



}
