package com.programmingjavaweb.controller.admin;

import com.programmingjavaweb.constant.SystemConstant;
import com.programmingjavaweb.enums.BuildingTypeEnum;
import com.programmingjavaweb.model.BuildingModel;
import com.programmingjavaweb.paging.PageRequest;
import com.programmingjavaweb.paging.Pageble;
import com.programmingjavaweb.service.BuildingService;
import com.programmingjavaweb.service.DistrictService;
import com.programmingjavaweb.service.impl.BuildingServiceImpl;
import com.programmingjavaweb.service.impl.DistrictServiceImpl;
import com.programmingjavaweb.sort.Sorter;
import com.programmingjavaweb.utils.FormUtils;
import com.programmingjavaweb.utils.message.MessageUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ResourceBundle;

@WebServlet(urlPatterns = {"/admin-building"})
public class BuildingController extends HttpServlet {

    private BuildingService buildingService;
    private DistrictService districtService;

    public BuildingController() {
        this.buildingService = new BuildingServiceImpl();
        this.districtService = new DistrictServiceImpl();
    }

    ResourceBundle resourceBundle = ResourceBundle.getBundle("message");

    protected void doGet (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        BuildingModel model = FormUtils.toModel(BuildingModel.class, request);
        String view = "";
        if(model.getType().equals(SystemConstant.LIST)) {
            Pageble pageble = new PageRequest(model.getPage(), model.getMaxPageItems(), new Sorter(model.getSortName(), model.getSortBy()));
            model.setListResult(buildingService.findAll(pageble));
            model.setTotalItems(buildingService.getTotalItem());
            model.setTotalPages((int)Math.ceil((double)model.getTotalItems() / model.getMaxPageItems()));
            view = "/views/admin/building/list.jsp";
        } else if (model.getType().equals(SystemConstant.EDIT)) {
            if(model.getId() != null) {
                model = buildingService.findOne(model.getId());
            }
            request.setAttribute(SystemConstant.DISTRICTS, districtService.findAll());
            view = "/views/admin/building/edit.jsp";
        }
        if(model.getMessage() != null && model.getAlert() != null) {
            MessageUtils.of(resourceBundle.getString(model.getMessage()), model.getAlert()).buildMessage(request);
        }
        request.setAttribute(SystemConstant.BUILDING_TYPE, BuildingTypeEnum.values());
        request.setAttribute(SystemConstant.MODEL, model);
        RequestDispatcher rd = request.getRequestDispatcher(view);
        rd.forward(request, response);
    }

    protected void doPost (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}
