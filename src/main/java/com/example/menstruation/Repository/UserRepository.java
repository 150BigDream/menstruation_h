package com.example.menstruation.Repository;

import com.example.menstruation.Bean.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

public interface UserRepository extends JpaRepository<User, String> {
     User findByUserID(Integer userid);
     @Transactional
     @Modifying
     @Query(value = "update user set fsustainday=?2,fintervalday=?3 where userid=?1",nativeQuery = true)
     void updateDate(Integer userid,Integer fsus,Integer finter);

}
