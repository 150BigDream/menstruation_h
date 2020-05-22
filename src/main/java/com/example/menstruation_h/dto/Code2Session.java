package com.example.menstruation_h.dto;

import lombok.Data;

@Data
public class Code2Session {
    String openid;
    String session_key;
    String unionid;
    int errcode;
    String errmsg;
}
