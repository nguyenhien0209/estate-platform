package com.programmingjavaweb.service;

import com.programmingjavaweb.model.BuildingModel;

public interface BuildingService {
    BuildingModel save(BuildingModel buildingModel);
    BuildingModel update (BuildingModel buildingModel);
    void delete (Long[] ids);
}
