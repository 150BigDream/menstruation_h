package com.example.menstruation.Repository;

import com.example.menstruation.Bean.Time;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

public interface TimeRepository extends JpaRepository<Time, String> {
//    @Transactional
//    @Modifying
//    @Query(value = "insert into time(starttime,userid) values(?1,?2)",nativeQuery = true)
//    void insertTo(Date start,Integer userid);
    @Transactional
    @Modifying
    @Query(value = "update time set endtime=?1 where id=?2",nativeQuery = true)
    void updateTime(Date end,Integer userid);

//    Time findByStartTimeAndUserid(Date starttime,Integer id);

    List<Time> findByUserid(Integer userid);

    @Query(value = "select * from time  where userid=?1 order by id desc limit 0,2 ",nativeQuery = true)
    List<Time>  findTop2(Integer userid);

    Integer countAllByUserid(Integer userid);

    @Query(value = "select * from time  where userid=?1 order by id desc limit 0,1 ",nativeQuery = true)
    Time findTop1(Integer userid);



}
