package com.programmingjavaweb.dao;

import com.programmingjavaweb.model.BuildingModel;
import com.programmingjavaweb.paging.Pageble;

import java.util.List;

public interface BuildingDAO extends GenericDAO<BuildingModel> {
    Long save( BuildingModel buildingModel);
    void update(BuildingModel buildingModel);
    void delete (Long id);
    BuildingModel findOne(Long id);
    List<BuildingModel> findAll (Pageble pageble);
    int getTotalItem();
}
