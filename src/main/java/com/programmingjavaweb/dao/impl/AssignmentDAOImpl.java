package com.programmingjavaweb.dao.impl;

import com.programmingjavaweb.dao.AssignmentDAO;
import com.programmingjavaweb.mapper.AssignmentBuildingMapper;
import com.programmingjavaweb.model.AssignmentBuildingModel;

import java.util.List;

public class AssignmentDAOImpl extends AbstractDAO<AssignmentBuildingModel> implements AssignmentDAO {

    @Override
    public AssignmentBuildingModel existsByUserIdAndBuildingId(Long userId, Long buildingId) {
        StringBuilder sql = new StringBuilder(" SELECT * FROM assignmentbuilding ");
        sql.append(" WHERE staffid = ? AND buildingid = ?");
        List<AssignmentBuildingModel> assignmentBuildingModels = query(sql.toString(), new AssignmentBuildingMapper() , userId, buildingId);
        return assignmentBuildingModels.isEmpty() ? null : assignmentBuildingModels.get(0);
    }

    @Override
    public void deleteByBuildingId(Long buildingId) {
        String sql = "DELETE FROM assignmentbuilding WHERE buildingid = ?";
        update(sql, buildingId);
    }

    @Override
    public void save(Long userId, Long buildingId) {
        StringBuilder sql = new StringBuilder("INSERT INTO assignmentbuilding ( ");
        sql.append(" staffid, buildingid )");
        sql.append(" VALUES (?, ?) ");
        insert(sql.toString(), userId, buildingId);
    }
}
