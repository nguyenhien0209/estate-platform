package com.programmingjavaweb.controller.admin.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.programmingjavaweb.model.AssignmentBuildingModel;
import com.programmingjavaweb.service.AssignmentBuildingService;
import com.programmingjavaweb.service.impl.AssignmentBuildingServiceImpl;
import com.programmingjavaweb.utils.HttpUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/api-assignment-building"})
public class AssignmentBuildingAPI extends HttpServlet {

    private AssignmentBuildingService assignmentBuildingService;

    public AssignmentBuildingAPI() {
        assignmentBuildingService = new AssignmentBuildingServiceImpl();
    }

    protected void doPut (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        AssignmentBuildingModel assignmentBuildingModel = HttpUtils.of(request.getReader()).toModel(AssignmentBuildingModel.class);
        assignmentBuildingService.assignStaffToBuilding(assignmentBuildingModel.getIds(), assignmentBuildingModel.getBuildingId());
        objectMapper.writeValue(response.getOutputStream(), "");
    }
}
