package com.programmingjavaweb.service.impl;

import com.programmingjavaweb.dao.AssignmentDAO;
import com.programmingjavaweb.dao.impl.AssignmentDAOImpl;
import com.programmingjavaweb.service.AssignmentBuildingService;

public class AssignmentBuildingServiceImpl implements AssignmentBuildingService {

    private AssignmentDAO assignmentDAO;

    public AssignmentBuildingServiceImpl() {
        assignmentDAO = new AssignmentDAOImpl();
    }

    @Override
    public void assignStaffToBuilding(Long[] staffIds, Long buildingId) {
        assignmentDAO.deleteByBuildingId(buildingId);
        for(Long item: staffIds) {
            assignmentDAO.save(item, buildingId);
        }
    }
}
