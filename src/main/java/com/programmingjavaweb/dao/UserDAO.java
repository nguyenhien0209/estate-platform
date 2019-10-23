package com.programmingjavaweb.dao;

import com.programmingjavaweb.model.UserModel;

public interface UserDAO {
    UserModel findUserByUsernameAndPasswordAndStatus (String userName, String password, Integer status);
}
