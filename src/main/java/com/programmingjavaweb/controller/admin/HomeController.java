package com.programmingjavaweb.controller.admin;

import com.programmingjavaweb.constant.SystemConstant;
import com.programmingjavaweb.model.UserModel;
import com.programmingjavaweb.security.AuthenticationFilter;
import com.programmingjavaweb.utils.FormUtils;
import com.programmingjavaweb.utils.SessionUtil;
import com.programmingjavaweb.utils.message.MessageUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ResourceBundle;

@WebServlet(urlPatterns = {"/admin-home", "/dang-nhap", "/thoat"})
public class HomeController extends HttpServlet {
    ResourceBundle resourceBundle = ResourceBundle.getBundle("message");
    protected void doGet (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");;
        if(action != null && action.equals(SystemConstant.LOGIN)) {
            UserModel model = FormUtils.toModel(UserModel.class, request);
            if(model.getMessage() != null && model.getAlert() != null) {
                MessageUtils.of(resourceBundle.getString(model.getMessage()), model.getAlert() ).buildMessage(request);
            }
            RequestDispatcher rd = request.getRequestDispatcher("/views/login.jsp");
            rd.forward(request, response);
        } else if (action != null && action.equals(SystemConstant.LOGOUT)) {
            SessionUtil.getInstance().removeValue(request, SystemConstant.USERMODEL);
            response.sendRedirect(request.getContextPath() + "/dang-nhap?action=login");
        } else {
            RequestDispatcher rd = request.getRequestDispatcher("/views/admin/home.jsp");
            rd.forward(request, response);
        }
    }

    protected void doPost (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action != null && action.equals(SystemConstant.LOGIN)) {
            UserModel model = FormUtils.toModel(UserModel.class, request);
            String url = AuthenticationFilter.of(model.getUserName(), model.getPassword()).urlRedirect(request);
            response.sendRedirect(request.getContextPath() + url);
        }
    }
}
