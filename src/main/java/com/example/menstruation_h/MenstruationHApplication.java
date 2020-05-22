package com.example.menstruation_h;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan("com.example.menstruation_h.mapper")
@SpringBootApplication
public class MenstruationHApplication {

    public static void main(String[] args) {
        SpringApplication.run(MenstruationHApplication.class, args);
    }

}
