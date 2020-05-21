package com.example.menstruation.Service;

import com.example.menstruation.Bean.User;

public interface UserService {
    User find(Integer userid);
    void updateDate(Integer userid);
}
