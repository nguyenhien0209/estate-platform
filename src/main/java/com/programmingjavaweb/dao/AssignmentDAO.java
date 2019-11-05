package com.programmingjavaweb.dao;

import com.programmingjavaweb.model.AssignmentBuildingModel;

public interface AssignmentDAO {
    AssignmentBuildingModel existsByUserIdAndBuildingId(Long userId, Long buildingId);
}
