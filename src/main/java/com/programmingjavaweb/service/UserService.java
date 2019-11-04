package com.programmingjavaweb.service;

import com.programmingjavaweb.model.UserModel;

import java.util.List;

public interface UserService {
    UserModel findUserByUsernameAndPasswordAndStatus(String userName, String password, Integer status);
    List<UserModel> findAll (UserModel condition);
}
