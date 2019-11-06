package com.programmingjavaweb.dao;

import com.programmingjavaweb.builder.BuildingBuilder;
import com.programmingjavaweb.model.BuildingModel;
import com.programmingjavaweb.paging.Pageble;

import java.util.List;

public interface BuildingDAO  {
    Long save( BuildingModel buildingModel);
    void update(BuildingModel buildingModel);
    void delete (Long id);
    BuildingModel findOne(Long id);
    List<BuildingModel> findAll (BuildingBuilder builder, Pageble pageble);
    int getTotalItem(BuildingBuilder builder);
}
