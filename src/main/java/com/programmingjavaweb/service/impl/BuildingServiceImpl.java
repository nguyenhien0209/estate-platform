package com.programmingjavaweb.service.impl;

import com.programmingjavaweb.dao.BuildingDAO;
import com.programmingjavaweb.model.BuildingModel;
import com.programmingjavaweb.paging.Pageble;
import com.programmingjavaweb.service.BuildingService;

import javax.inject.Inject;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

public class BuildingServiceImpl implements BuildingService {

    @Inject
    private BuildingDAO buildingDAO;

    @Override
    public BuildingModel save(BuildingModel buildingModel) {
        buildingModel.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        buildingModel.setType(String.join(",", buildingModel.getTypeArrays()));
        Long newId = buildingDAO.save(buildingModel);
        return buildingDAO.findOne(newId);
    }

    @Override
    public BuildingModel update(BuildingModel buildingModel) {
        BuildingModel oldBuilding = buildingDAO.findOne(buildingModel.getId());
        buildingModel.setCreatedDate(oldBuilding.getCreatedDate());
        buildingModel.setCreatedBy(oldBuilding.getCreatedBy());
        buildingModel.setModifiedDate(new Timestamp(System.currentTimeMillis()));
        buildingModel.setType(String.join(",", buildingModel.getTypeArrays()));
        buildingDAO.update(buildingModel);
        return buildingDAO.findOne(buildingModel.getId());
    }

    @Override
    public void delete(Long[] ids) {
        for(Long id : ids){
            buildingDAO.delete(id);
        }
    }

    @Override
    public List<BuildingModel> findAll(Pageble pageble) {
        return buildingDAO.findAll(pageble);
    }

    @Override
    public int getTotalItem() {
        return buildingDAO.getTotalItem();
    }

    @Override
    public BuildingModel findOne(Long id) {
        return buildingDAO.findOne(id);
    }

    @Override
    public Map<String, String> getBuildingTypes() {
        return null;
    }
}
