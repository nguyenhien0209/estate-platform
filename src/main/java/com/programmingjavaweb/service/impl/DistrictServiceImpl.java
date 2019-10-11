package com.programmingjavaweb.service.impl;

import com.programmingjavaweb.dao.DistrictDAO;
import com.programmingjavaweb.model.DistrictModel;
import com.programmingjavaweb.service.DistrictService;

import javax.inject.Inject;
import java.util.List;

public class DistrictServiceImpl implements DistrictService {

    @Inject
    private DistrictDAO districtDAO;

    @Override
    public List<DistrictModel> findAll() {
        return districtDAO.findAll();
    }
}
