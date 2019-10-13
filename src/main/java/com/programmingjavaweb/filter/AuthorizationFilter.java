package com.programmingjavaweb.filter;


import com.programmingjavaweb.constant.SystemConstant;
import com.programmingjavaweb.model.UserModel;
import com.programmingjavaweb.utils.SessionUtil;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthorizationFilter implements Filter {

    private ServletContext context;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.context = filterConfig.getServletContext();
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String url = request.getRequestURI();
        if(url.startsWith("/admin")) {
            UserModel userModel = (UserModel) SessionUtil.getInstance().getValue(request, SystemConstant.USERMODEL);
            if(userModel != null && userModel.getRoleModel().getRoleCode().equals("admin")) {
                filterChain.doFilter(servletRequest, servletResponse);
            } else {
                response.sendRedirect(request.getContextPath() + "/dang-nhap?action=login&message=not_login&alert=danger");
            }
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
