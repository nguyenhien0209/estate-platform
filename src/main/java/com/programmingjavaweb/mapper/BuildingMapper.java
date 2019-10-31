package com.programmingjavaweb.mapper;

import com.programmingjavaweb.model.BuildingModel;
import org.apache.commons.lang.StringUtils;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BuildingMapper implements RowMapper<BuildingModel> {
    @Override
    public BuildingModel mapRow(ResultSet resultSet) {
//        try {
            BuildingModel model = new BuildingModel();
//            model.setId(resultSet.getLong("id"));
//            model.setName(resultSet.getString("name"));
//            model.setDistrict(resultSet.getString("district"));
//            model.setWard(resultSet.getString("ward"));
//            model.setStreet(resultSet.getString("street"));
//            model.setStructure(resultSet.getString("structure"));
//            model.setNumberOfBasement(resultSet.getInt("numberofbasement"));
//            model.setBuildingArea(resultSet.getDouble("buildingarea"));
//            model.setDirection(resultSet.getString("direction"));
//            model.setLevelBuilding(resultSet.getString("levelbuilding"));
//            model.setRentArea(resultSet.getString("rentarea"));
//            model.setAreaDescription(resultSet.getString("areadescription"));
//            model.setCostRent(resultSet.getInt("costrent"));
//            model.setCostDescription(resultSet.getString("costdescription"));
//            model.setServiceCost(resultSet.getString("servicecost"));
//            model.setCarCost(resultSet.getString("carcost"));
//            model.setMotorbikeCost(resultSet.getString("motorbikecost"));
//            model.setOvertimeCost(resultSet.getString("overtimecost"));
//            model.setElectricityCost(resultSet.getString("electricitycost"));
//            model.setDeposit(resultSet.getString("deposit"));
//            model.setPayment(resultSet.getString("payment"));
//            model.setTimeContract(resultSet.getString("electricitycost"));
//            model.setTimeDecorator(resultSet.getString("timedecorator"));
//            model.setManagerName(resultSet.getString("managername"));
//            model.setManagerPhone(resultSet.getString("managerphone"));
//            model.setCommission(resultSet.getString("commission"));
//            model.setNote(resultSet.getString("note"));
//            model.setLink(resultSet.getString("link"));
//            model.setLocation(resultSet.getString("location"));
//            model.setImage(resultSet.getString("image"));
//            model.setType(resultSet.getString("type"));
//            if(StringUtils.isNotBlank(resultSet.getString("type"))) {
//                model.setTypeArrays(resultSet.getString("type").split(","));
//            }
//            model.setCreatedDate(resultSet.getTimestamp("createddate"));
//            model.setCreatedBy(resultSet.getString("createdby"));
//            if(resultSet.getTimestamp("modifieddate") != null) {
//                model.setModifiedDate(resultSet.getTimestamp("modifieddate"));
//            }
//            if(resultSet.getString("modifiedby") != null) {
//                model.setModifiedBy(resultSet.getString("modifiedby"));
//            }
            return model;
//        } catch (SQLException e) {
//            e.printStackTrace();
//            return null;
//        }
    }
}
