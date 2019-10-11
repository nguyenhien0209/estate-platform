package com.programmingjavaweb.dao.impl;

import com.programmingjavaweb.dao.BuildingDAO;
import com.programmingjavaweb.mapper.BuildingMapper;
import com.programmingjavaweb.model.BuildingModel;
import com.programmingjavaweb.paging.Pageble;
import org.apache.commons.lang.StringUtils;

import java.util.List;

public class BuildingDAOImpl extends AbstractDAO<BuildingModel> implements BuildingDAO {
    @Override
    public Long save(BuildingModel buildingModel) {
        StringBuilder sql = new StringBuilder("INSERT INTO building (name, district, ward, street, structure, numberofbasement," +
                " buildingarea, direction, levelbuilding, rentarea, areadescription, costrent, costdescription, servicecost," +
                " carcost, motorbikecost, overtimecost, electricitycost, deposit, payment, timecontract, timedecorator," +
                " managername, managerphone, commission, note, link, location, image, type, createddate, createdby ) ");
        sql.append(" VALUES( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )" );
        return insert(sql.toString(), buildingModel.getName(), buildingModel.getDistrict(), buildingModel.getWard(), buildingModel.getStreet(),
                buildingModel.getStructure(), buildingModel.getNumberOfBasement(), buildingModel.getBuildingArea(), buildingModel.getDirection(),
                buildingModel.getLevelBuilding(), buildingModel.getRentArea(), buildingModel.getAreaDescription(), buildingModel.getCostRent(),
                buildingModel.getCostDescription(), buildingModel.getServiceCost(), buildingModel.getCarCost(), buildingModel.getMotorbikeCost(),
                buildingModel.getOvertimeCost(), buildingModel.getElectricityCost(), buildingModel.getDeposit(), buildingModel.getPayment(),
                buildingModel.getTimeContract(), buildingModel.getTimeDecorator(), buildingModel.getManagerName(), buildingModel.getManagerPhone(),
                buildingModel.getCommission(), buildingModel.getNote(), buildingModel.getLink(), buildingModel.getLocation(), buildingModel.getImage(),
                buildingModel.getType(), buildingModel.getCreatedDate(), buildingModel.getCreatedBy());
    }

    @Override
    public void update(BuildingModel buildingModel) {
        StringBuilder sql = new StringBuilder("UPDATE building SET name = ?, district = ?, ward = ?, street = ?, structure = ?, " +
                "numberofbasement = ?, buildingarea = ?, direction = ?, levelbuilding = ?, rentarea = ?, areadescription = ?, " +
                "costrent = ?, costdescription = ?, servicecost = ?, carcost = ?, motorbikecost = ?, overtimecost = ?, electricitycost = ?," +
                "deposit = ?, payment = ?, timecontract = ?, timedecorator = ?, managername = ?, managerphone = ?, commission = ?, " +
                "note = ?, link = ?, location = ?, image = ?, type = ?, createdby = ?, modifiedby = ?, createddate = ?, modifieddate = ?  ");
        sql.append(" WHERE id = ? ");
        update(sql.toString(), buildingModel.getName(), buildingModel.getDistrict(), buildingModel.getWard(), buildingModel.getStreet(),
                buildingModel.getStructure(), buildingModel.getNumberOfBasement(), buildingModel.getBuildingArea(), buildingModel.getDirection(),
                buildingModel.getLevelBuilding(), buildingModel.getRentArea(), buildingModel.getAreaDescription(), buildingModel.getCostRent(),
                buildingModel.getCostDescription(), buildingModel.getServiceCost(), buildingModel.getCarCost(), buildingModel.getMotorbikeCost(),
                buildingModel.getOvertimeCost(), buildingModel.getElectricityCost(), buildingModel.getDeposit(), buildingModel.getPayment(),
                buildingModel.getTimeContract(), buildingModel.getTimeDecorator(), buildingModel.getManagerName(), buildingModel.getManagerPhone(),
                buildingModel.getCommission(), buildingModel.getNote(), buildingModel.getLink(), buildingModel.getLocation(), buildingModel.getImage(),
                buildingModel.getType(), buildingModel.getCreatedBy(), buildingModel.getModifiedBy(), buildingModel.getCreatedDate(), buildingModel.getModifiedDate(),
                buildingModel.getId());
    }

    @Override
    public void delete(Long id) {
        String sql = "DELETE FROM building WHERE id = ?";
        update(sql, id);
    }

    @Override
    public BuildingModel findOne(Long id) {
        String sql = "SELECT * FROM building WHERE id = ?";
        List<BuildingModel> buildingModels = query(sql, new BuildingMapper(),id);
        return buildingModels.isEmpty() ? null : buildingModels.get(0);
    }

    @Override
    public List<BuildingModel> findAll(Pageble pageble) {
        StringBuilder sql = new StringBuilder("SELECT * FROM building as b ");
        sql.append(" WHERE 1 = 1");
        if(StringUtils.isNotBlank(pageble.getSorter().getSortName()) && StringUtils.isNotBlank(pageble.getSorter().getSortBy())) {
            sql.append(" ORDER BY " + pageble.getSorter().getSortName() + " " + pageble.getSorter().getSortBy() + " ");
        }
        if(pageble.getOffset() != null && pageble.getLimit() != null) {
            sql.append(" LIMIT " + pageble.getOffset() + "," + pageble.getLimit() + " ");
        }
        return query(sql.toString(), new BuildingMapper());
    }

    @Override
    public int getTotalItem() {
        StringBuilder sql = new StringBuilder("SELECT count(*) FROM building ");
        return count(sql.toString());
    }
}
