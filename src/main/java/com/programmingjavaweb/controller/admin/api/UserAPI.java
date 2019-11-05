package com.programmingjavaweb.controller.admin.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.programmingjavaweb.model.UserModel;
import com.programmingjavaweb.service.UserService;
import com.programmingjavaweb.service.impl.UserServiceImpl;
import com.programmingjavaweb.utils.FormUtils;
import com.programmingjavaweb.utils.HttpUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/api-user"})
public class UserAPI extends HttpServlet {

    private UserService userService;

    public UserAPI() {
        userService = new UserServiceImpl();
    }

    protected void doGet (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        ObjectMapper objectMapper = new ObjectMapper();
//        request.setCharacterEncoding("UTF-8");
//        response.setContentType("application/json");
//        UserModel userModel = FormUtils.toModel(UserModel.class, request);
//        objectMapper.writeValue(response.getOutputStream(), userService.findAll(userModel));
    }

    protected void doPost (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        UserModel userModel = HttpUtils.of(request.getReader()).toModel(UserModel.class);
        objectMapper.writeValue(response.getOutputStream(), userService.findAll(userModel));
    }

    protected void doPut (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    protected void doDelete (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
}
