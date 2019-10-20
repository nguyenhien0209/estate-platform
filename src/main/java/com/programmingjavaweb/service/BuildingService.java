package com.programmingjavaweb.service;

import com.programmingjavaweb.model.BuildingModel;
import com.programmingjavaweb.paging.Pageble;

import java.util.List;
import java.util.Map;

public interface BuildingService {
    BuildingModel save(BuildingModel buildingModel);
    BuildingModel update (BuildingModel buildingModel);
    void delete (Long[] ids);
    List<BuildingModel> findAll(Pageble pageble);
    int getTotalItem();
    BuildingModel findOne(Long id);
    Map<String, String> getBuildingTypes();
}
