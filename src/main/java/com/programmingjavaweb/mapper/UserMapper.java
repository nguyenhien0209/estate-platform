package com.programmingjavaweb.mapper;

import com.programmingjavaweb.model.RoleModel;
import com.programmingjavaweb.model.UserModel;
import com.programmingjavaweb.utils.ConverterUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<UserModel> {
    @Override
    public UserModel mapRow(ResultSet resultSet) {
        UserModel userModel = new ConverterUtil().resultToModel(new UserModel(), resultSet);
        RoleModel roleModel = new ConverterUtil().resultToModel(new RoleModel(), resultSet);
        if(roleModel != null) {
            userModel.setRoleModel(roleModel);
        }
        return userModel;
    }
}
