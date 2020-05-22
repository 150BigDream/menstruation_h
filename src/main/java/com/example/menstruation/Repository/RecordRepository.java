package com.example.menstruation.Repository;

import com.example.menstruation.Bean.Record;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

public interface RecordRepository extends JpaRepository<Record, String> {
//    @Transactional
//    @Modifying
//    @Query(value = "insert into record(time,userid) values(?1,?2)",nativeQuery = true)
//    void insertTo(Date date, Integer userid);
    @Query(value = "select * from record where userid1=?1 and time=?2 limit 0,1",nativeQuery = true)
    Record findByuat(Integer userid,String date);

    @Transactional
    @Modifying
    @Query(value = "update record set flow=?2,pain=?3 where id=?1",nativeQuery = true)
    void updateTom(Integer id,Integer flow,Integer pain);


    @Transactional
    @Modifying
    @Query(value = "update record set drinkwater=?2,exercise=?3,earlytobed=?4, eatbreakfast=?5,reading=?6 where id=?1",nativeQuery = true)
    void updateToH(Integer id,Integer drinkwater,Integer exercise,Integer earlytobed,Integer eatbreakfast,Integer reading);


}
