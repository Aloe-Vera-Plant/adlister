package com.codeup.adlister.dao;

import com.codeup.adlister.models.User;

import java.sql.SQLException;
import java.util.List;

public interface Users {

    User findByUsername(String username);
    User findUserById(long userId);
    Long insert(User user);
    void updateUserInfo(String username, String pfp, String email);
    void updateUserPass(String newPassword, String username);
    User findUserByIDNumber(long idNumber);

}
