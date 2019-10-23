package com.programmingjavaweb.service.impl;

import com.programmingjavaweb.dao.DistrictDAO;
import com.programmingjavaweb.dao.impl.DistrictDAOImpl;
import com.programmingjavaweb.model.DistrictModel;
import com.programmingjavaweb.service.DistrictService;

import java.util.List;

public class DistrictServiceImpl implements DistrictService {

    private DistrictDAO districtDAO;

    public DistrictServiceImpl() {
        this.districtDAO = new DistrictDAOImpl();
    }

    public List<DistrictModel> findAll() {
        return districtDAO.findAll();
    }
}
