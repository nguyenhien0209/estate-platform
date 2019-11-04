package com.programmingjavaweb.dao;

import com.programmingjavaweb.model.UserModel;

import java.util.List;

public interface UserDAO {
    UserModel findUserByUsernameAndPasswordAndStatus (String userName, String password, Integer status);
    List<UserModel> findByRoleAndStatus(String roleCode, int status);
}
