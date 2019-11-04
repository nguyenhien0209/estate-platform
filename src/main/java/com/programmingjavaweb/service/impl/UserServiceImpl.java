package com.programmingjavaweb.service.impl;

import com.programmingjavaweb.dao.AssignmentDAO;
import com.programmingjavaweb.dao.UserDAO;
import com.programmingjavaweb.dao.impl.AssignmentDAOImpl;
import com.programmingjavaweb.dao.impl.UserDAOImpl;
import com.programmingjavaweb.model.AssignmentBuildingModel;
import com.programmingjavaweb.model.UserModel;
import com.programmingjavaweb.service.UserService;

import java.util.List;


public class UserServiceImpl implements UserService {

    private UserDAO userDAO;
    private AssignmentDAO assignmentDAO;

    public UserServiceImpl() {
        userDAO = new UserDAOImpl();
        assignmentDAO = new AssignmentDAOImpl();
    }

    @Override
    public UserModel findUserByUsernameAndPasswordAndStatus(String userName, String password, Integer status) {
        return userDAO.findUserByUsernameAndPasswordAndStatus(userName, password, status);
    }

    @Override
    public List<UserModel> findAll(UserModel condition) {
        List<UserModel> staffs = userDAO.findByRoleAndStatus(condition.getRoleCode(), 1);
        for(UserModel user : staffs) {
            AssignmentBuildingModel assignmentBuildingModel = assignmentDAO.existsByUserIdAndBuildingId(user.getId(), condition.getBuildingId());
            if(assignmentBuildingModel != null) {
                user.setChecked("checked");
            }
        }
        return staffs;
    }
}
