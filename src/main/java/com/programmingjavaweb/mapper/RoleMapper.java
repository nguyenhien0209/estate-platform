package com.programmingjavaweb.mapper;

import com.programmingjavaweb.model.RoleModel;
import com.programmingjavaweb.utils.ConverterUtil;

import java.sql.ResultSet;

public class RoleMapper implements RowMapper<RoleModel> {

    @Override
    public RoleModel mapRow(ResultSet resultSet) {
        return new ConverterUtil().resultToModel(new RoleModel(), resultSet);
    }
}
