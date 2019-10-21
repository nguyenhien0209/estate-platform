package com.programmingjavaweb.controller.admin.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.programmingjavaweb.constant.SystemConstant;
import com.programmingjavaweb.dao.BuildingDAO;
import com.programmingjavaweb.model.BuildingModel;
import com.programmingjavaweb.model.UserModel;
import com.programmingjavaweb.service.BuildingService;
import com.programmingjavaweb.service.impl.BuildingServiceImpl;
import com.programmingjavaweb.utils.HttpUtils;
import com.programmingjavaweb.utils.SessionUtil;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/api-admin-building"})
public class BuildingAPI extends HttpServlet {

    @Inject
    private BuildingService buildingService;

    protected void doPost (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        BuildingModel model = HttpUtils.of(request.getReader()).toModel(BuildingModel.class);
        model.setCreatedBy(((UserModel)(SessionUtil.getInstance().getValue(request, SystemConstant.USERMODEL))).getUserName());
        model = buildingService.save(model);
        objectMapper.writeValue(response.getOutputStream(), model);
    }

    protected void doPut (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        BuildingModel model = HttpUtils.of(request.getReader()).toModel(BuildingModel.class);
        model.setModifiedBy(((UserModel)(SessionUtil.getInstance().getValue(request, SystemConstant.USERMODEL))).getUserName());
        model = buildingService.update(model);
        objectMapper.writeValue(response.getOutputStream(), model);
    }

    protected void doDelete (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        BuildingModel model = HttpUtils.of(request.getReader()).toModel(BuildingModel.class);
        buildingService.delete(model.getIds());
        objectMapper.writeValue(response.getOutputStream(), "{}");
    }
}
