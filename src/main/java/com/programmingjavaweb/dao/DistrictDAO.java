package com.programmingjavaweb.dao;

import com.programmingjavaweb.model.DistrictModel;

import java.util.List;

public interface DistrictDAO extends GenericDAO<DistrictModel> {
    List<DistrictModel> findAll();
}
