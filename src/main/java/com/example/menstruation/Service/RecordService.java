package com.example.menstruation.Service;

import java.util.Date;

public interface RecordService {
//    void insert(Integer userid, Date date);
    void update(Integer id, Integer flow,Integer pain);
    void updateH(Integer id, Integer[] habbit);
}
