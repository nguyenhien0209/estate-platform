package com.programmingjavaweb.controller.admin;

import com.programmingjavaweb.constant.SystemConstant;
import com.programmingjavaweb.model.BuildingModel;
import com.programmingjavaweb.paging.PageRequest;
import com.programmingjavaweb.paging.Pageble;
import com.programmingjavaweb.service.BuildingService;
import com.programmingjavaweb.sort.Sorter;
import com.programmingjavaweb.utils.FormUtils;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/admin-building"})
public class BuildingController extends HttpServlet {

    @Inject
    private BuildingService buildingService;

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
            view = "/views/admin/building/edit.jsp";
        }
        request.setAttribute(SystemConstant.MODEL, model);
        RequestDispatcher rd = request.getRequestDispatcher(view);
        rd.forward(request, response);
    }

    protected void doPost (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}
