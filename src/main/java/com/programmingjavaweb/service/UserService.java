package com.programmingjavaweb.service;

import com.programmingjavaweb.model.UserModel;

public interface UserService {
    UserModel findUserByUsernameAndPasswordAndStatus(String userName, String password, Integer status);
}
