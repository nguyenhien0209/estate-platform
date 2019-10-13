package com.programmingjavaweb.dao.impl;

import com.programmingjavaweb.dao.UserDAO;
import com.programmingjavaweb.mapper.UserMapper;
import com.programmingjavaweb.model.UserModel;

import java.util.List;

public class UserDAOImpl extends AbstractDAO<UserModel> implements UserDAO {
    @Override
    public UserModel findUserByUsernameAndPasswordAndStatus(String userName, String password, Integer status) {
        StringBuilder sql = new StringBuilder("SELECT * FROM user as u");
        sql.append(" INNER JOIN role as r ON r.id = u.roleid");
        sql.append(" WHERE u.username = ? AND u.password = ? AND u.status = ?");
        List<UserModel> models = query(sql.toString(), new UserMapper(), userName, password, status);
        return models.isEmpty() ? null : models.get(0);
    }
}
