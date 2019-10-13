package com.programmingjavaweb.mapper;

import com.programmingjavaweb.model.RoleModel;
import com.programmingjavaweb.model.UserModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<UserModel> {
    @Override
    public UserModel mapRow(ResultSet resultSet) {
        try {
            UserModel model = new UserModel();
            model.setId(resultSet.getLong("id"));
            model.setUserName(resultSet.getString("username"));
            model.setPassword(resultSet.getString("password"));
            model.setFullName(resultSet.getString("fullname"));
            model.setStatus(resultSet.getInt("status"));
            try {
                model.setRoleModel((new RoleMapper()).mapRow(resultSet));
            } catch (Exception e) {
                e.printStackTrace();
            }
            model.setCreatedDate(resultSet.getTimestamp("createddate"));
            model.setCreatedBy(resultSet.getString("createdby"));
            if(resultSet.getTimestamp("modifieddate") != null) {
                model.setModifiedDate(resultSet.getTimestamp("modifieddate"));
            }
            if(resultSet.getString("modifiedby") != null) {
                model.setModifiedBy(resultSet.getString("modifiedby"));
            }
            return model;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
