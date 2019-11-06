package com.programmingjavaweb.service.impl;

import com.programmingjavaweb.builder.BuildingBuilder;
import com.programmingjavaweb.dao.BuildingDAO;
import com.programmingjavaweb.dao.impl.BuildingDAOImpl;
import com.programmingjavaweb.model.BuildingModel;
import com.programmingjavaweb.paging.Pageble;
import com.programmingjavaweb.service.BuildingService;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

public class BuildingServiceImpl implements BuildingService {

    private BuildingDAO buildingDAO;

    public BuildingServiceImpl() {
        this.buildingDAO = new BuildingDAOImpl();
    }

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
        for (Long id : ids) {
            buildingDAO.delete(id);
        }
    }

    @Override
    public List<BuildingModel> findAll(BuildingBuilder builder, Pageble pageble) {
        return buildingDAO.findAll(builder, pageble);
    }

    @Override
    public int getTotalItem(BuildingBuilder builder) {
        return buildingDAO.getTotalItem(builder);
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
