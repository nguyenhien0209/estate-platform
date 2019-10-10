package com.programmingjavaweb.dao;

import com.programmingjavaweb.model.BuildingModel;

public interface BuildingDAO extends GenericDAO<BuildingModel> {
    Long save( BuildingModel buildingModel);
    void update(BuildingModel buildingModel);
    void delete (Long id);
    BuildingModel findOne(Long id);
}
