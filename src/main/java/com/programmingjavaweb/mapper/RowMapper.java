package com.programmingjavaweb.mapper;

import java.sql.ResultSet;

public interface RowMapper <T> {
    T mapRow(ResultSet resultSet);
}
