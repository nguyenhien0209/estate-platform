package com.programmingjavaweb.model;

public class AssignmentBuildingModel extends AbstractModel {
    private Long buildingId;
    private Long staffId;
    private UserModel userModel = new UserModel();
    private BuildingModel buildingModel = new BuildingModel();

    public UserModel getUserModel() {
        return userModel;
    }

    public void setUserModel(UserModel userModel) {
        this.userModel = userModel;
    }

    public BuildingModel getBuildingModel() {
        return buildingModel;
    }

    public void setBuildingModel(BuildingModel buildingModel) {
        this.buildingModel = buildingModel;
    }

    public Long getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(Long buildingId) {
        this.buildingId = buildingId;
    }

    public Long getStaffId() {
        return staffId;
    }

    public void setStaffId(Long staffId) {
        this.staffId = staffId;
    }
}
