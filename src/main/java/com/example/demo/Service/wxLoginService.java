package com.example.demo.Service;

public interface wxLoginService {
     Object Login(String name);
     boolean reLogin(String openID);
     int getUserID(String openID);
}
