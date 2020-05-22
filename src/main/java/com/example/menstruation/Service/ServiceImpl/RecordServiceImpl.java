package com.example.menstruation.Service.ServiceImpl;


import com.example.menstruation.Bean.Record;
import com.example.menstruation.Repository.RecordRepository;
import com.example.menstruation.Service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class RecordServiceImpl implements RecordService {
    Map<Integer,Integer> map=new HashMap<Integer, Integer>();

    @Autowired
    RecordRepository recordRepository;
    public void insert(Integer userid, Date date) {
        Record record=new Record();
        record.setUserid(userid);
        record.setTime(date);
        recordRepository.save(record);
        map.put(userid,record.getId());
    }

    @Override
    public void update(Integer userid, Integer flow,Integer pain) {
        Date date=new Date();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        String str=simpleDateFormat.format(date);
//        try {
//            date= simpleDateFormat.parse(str);
//        }catch(Exception e){
//            e.printStackTrace();
//        }
        if(recordRepository.findByuat(userid,str)==null){
            insert(userid,date);
        }
        Integer id=map.get(userid);
        recordRepository.updateTom(id,flow,pain);
    }

    @Override
    public void updateH(Integer userid, Integer[] habbit) {
        Date date=new Date();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        String str=simpleDateFormat.format(date);
//        try {
//            date= simpleDateFormat.parse(str);
//        }catch(Exception e){
//            e.printStackTrace();
//        }
        if(recordRepository.findByuat(userid,str)==null){
            insert(userid,date);
        }
        Integer id=map.get(userid);
        recordRepository.updateToH(id,habbit[0],habbit[1],habbit[2],habbit[3],habbit[4]);
    }
}
