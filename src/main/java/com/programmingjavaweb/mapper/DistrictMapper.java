package com.programmingjavaweb.mapper;

import com.programmingjavaweb.model.DistrictModel;
import com.programmingjavaweb.utils.ConverterUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DistrictMapper implements RowMapper<DistrictModel> {
    @Override
    public DistrictModel mapRow(ResultSet resultSet) {
        return new ConverterUtil().resultToModel(new DistrictModel(), resultSet);
    }
}
