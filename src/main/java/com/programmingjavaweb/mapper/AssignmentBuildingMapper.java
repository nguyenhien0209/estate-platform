package com.programmingjavaweb.mapper;

import com.programmingjavaweb.model.AssignmentBuildingModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AssignmentBuildingMapper implements RowMapper<AssignmentBuildingModel> {
    @Override
    public AssignmentBuildingModel mapRow(ResultSet resultSet) {
        try {
            AssignmentBuildingModel model = new AssignmentBuildingModel();
            model.setId(resultSet.getLong("id"));
            try {
                model.setUserModel((new UserMapper()).mapRow(resultSet));
                model.setBuildingModel((new BuildingMapper()).mapRow(resultSet));
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
        } catch (SQLException e ) {
            e.printStackTrace();
            return null;
        }
    }
}
