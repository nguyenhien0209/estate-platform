package com.programmingjavaweb.mapper;

import com.programmingjavaweb.model.AssignmentBuildingModel;
import com.programmingjavaweb.utils.ConverterUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AssignmentBuildingMapper implements RowMapper<AssignmentBuildingModel> {
    @Override
    public AssignmentBuildingModel mapRow(ResultSet resultSet) {
        return new ConverterUtil().resultToModel(new AssignmentBuildingModel(), resultSet);
    }
}
