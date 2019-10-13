package com.programmingjavaweb.service.impl;

import com.programmingjavaweb.dao.UserDAO;
import com.programmingjavaweb.dao.impl.UserDAOImpl;
import com.programmingjavaweb.model.UserModel;
import com.programmingjavaweb.service.UserService;

import javax.inject.Inject;

public class UserServiceImpl implements UserService {

    private UserDAO userDAO;

    public UserServiceImpl() {
        userDAO = new UserDAOImpl();
    }

    @Override
    public UserModel findUserByUsernameAndPasswordAndStatus(String userName, String password, Integer status) {
        return userDAO.findUserByUsernameAndPasswordAndStatus(userName, password, status);
    }
}
