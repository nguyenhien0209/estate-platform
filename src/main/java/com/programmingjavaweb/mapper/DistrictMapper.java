package com.programmingjavaweb.mapper;

import com.programmingjavaweb.model.DistrictModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DistrictMapper implements RowMapper<DistrictModel> {
    @Override
    public DistrictModel mapRow(ResultSet resultSet) {
        try {
            DistrictModel model = new DistrictModel();
            model.setId(resultSet.getLong("id"));
            model.setName(resultSet.getString("name"));
            model.setDistrictCode(resultSet.getString("districtcode"));
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
