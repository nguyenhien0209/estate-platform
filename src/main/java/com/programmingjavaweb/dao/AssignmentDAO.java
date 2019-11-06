package com.programmingjavaweb.dao;

import com.programmingjavaweb.model.AssignmentBuildingModel;

public interface AssignmentDAO {
    AssignmentBuildingModel existsByUserIdAndBuildingId(Long userId, Long buildingId);
    void deleteByBuildingId(Long buildingId);
    void save(Long userId, Long buildingId);
}
