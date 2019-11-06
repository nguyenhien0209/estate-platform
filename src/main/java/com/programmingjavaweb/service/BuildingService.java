package com.programmingjavaweb.service;

import com.programmingjavaweb.builder.BuildingBuilder;
import com.programmingjavaweb.model.BuildingModel;
import com.programmingjavaweb.paging.Pageble;

import java.util.List;
import java.util.Map;

public interface BuildingService {
    BuildingModel save(BuildingModel buildingModel);
    BuildingModel update (BuildingModel buildingModel);
    void delete (Long[] ids);
    List<BuildingModel> findAll(BuildingBuilder builder, Pageble pageble);
    int getTotalItem(BuildingBuilder builder);
    BuildingModel findOne(Long id);
    Map<String, String> getBuildingTypes();
}
