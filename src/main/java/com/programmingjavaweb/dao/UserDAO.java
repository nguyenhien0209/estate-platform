package com.programmingjavaweb.dao;

import com.programmingjavaweb.model.UserModel;

public interface UserDAO extends GenericDAO<UserModel> {
    UserModel findUserByUsernameAndPasswordAndStatus (String userName, String password, Integer status);
}
