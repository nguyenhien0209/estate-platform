package com.programmingjavaweb.mapper;

import com.programmingjavaweb.model.RoleModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RoleMapper implements RowMapper<RoleModel> {

    @Override
    public RoleModel mapRow(ResultSet resultSet) {
        try {
            RoleModel model = new RoleModel();
            model.setId(resultSet.getLong("id"));
            model.setName(resultSet.getString("name"));
            model.setRoleCode(resultSet.getString("rolecode"));
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
            e.printStackTrace();;
            return null;
        }
    }
}
