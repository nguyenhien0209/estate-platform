package com.programmingjavaweb.security;

import com.programmingjavaweb.constant.SystemConstant;
import com.programmingjavaweb.model.UserModel;
import com.programmingjavaweb.service.UserService;
import com.programmingjavaweb.service.impl.UserServiceImpl;
import com.programmingjavaweb.utils.SessionUtil;

import javax.servlet.http.HttpServletRequest;

public class AuthenticationImpl implements AuthenticationFilter {

    private String userName;
    private String password;
    private UserService userService;

    public AuthenticationImpl(String userName, String password) {
        this.userName = userName;
        this.password = password;
        userService = new UserServiceImpl();
    }

    @Override
    public String urlRedirect(HttpServletRequest request) {
        UserModel model = userService.findUserByUsernameAndPasswordAndStatus(this.userName, this.password, 1);
        if(model != null) {
            SessionUtil.getInstance().putValue(request, SystemConstant.USERMODEL, model);
            if(model.getRoleModel().getRoleCode().equals(SystemConstant.MANAGER)) {
                return "/admin-home";
            }
        } else {
            return "/dang-nhap?action=login&message=username_password_invalid&alert=danger";
        }
        return null;
    }
}
