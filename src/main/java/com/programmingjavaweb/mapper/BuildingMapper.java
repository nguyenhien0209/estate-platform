package com.programmingjavaweb.mapper;

import com.programmingjavaweb.model.BuildingModel;
import com.programmingjavaweb.utils.ConverterUtil;

import java.sql.ResultSet;

public class BuildingMapper implements RowMapper<BuildingModel> {
    @Override
    public BuildingModel mapRow(ResultSet resultSet) {
        return new ConverterUtil().resultToModel(new BuildingModel(), resultSet);
    }
}
