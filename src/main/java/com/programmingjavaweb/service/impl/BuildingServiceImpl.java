package com.programmingjavaweb.service.impl;

import com.programmingjavaweb.dao.BuildingDAO;
import com.programmingjavaweb.model.BuildingModel;
import com.programmingjavaweb.service.BuildingService;

import javax.inject.Inject;
import java.sql.Timestamp;

public class BuildingServiceImpl implements BuildingService {

    @Inject
    private BuildingDAO buildingDAO;

    @Override
    public BuildingModel save(BuildingModel buildingModel) {
        return null;
    }

    @Override
    public BuildingModel update(BuildingModel buildingModel) {
        return null;
    }

    @Override
    public void delete(Long[] ids) {
        for(Long id : ids){
            buildingDAO.delete(id);
        }
    }
}
