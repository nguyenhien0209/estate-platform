package com.programmingjavaweb.dao.impl;

import com.programmingjavaweb.dao.DistrictDAO;
import com.programmingjavaweb.mapper.DistrictMapper;
import com.programmingjavaweb.model.DistrictModel;

import java.util.List;

public class DistrictDAOImpl extends AbstractDAO<DistrictModel> implements DistrictDAO {
    @Override
    public List<DistrictModel> findAll() {
        StringBuilder sql = new StringBuilder("SELECT * FROM district");
        return query(sql.toString(), new DistrictMapper());
    }
}
