package com.programmingjavaweb.utils.message;

import com.programmingjavaweb.constant.SystemConstant;

import javax.servlet.http.HttpServletRequest;

public class MessageUtilsImpl implements MessageUtils {

    private String message;
    private String alert;

    public MessageUtilsImpl(String message, String alert) {
        this.message = message;
        this.alert = alert;
    }

    @Override
    public void buildMessage(HttpServletRequest request) {
        request.setAttribute(SystemConstant.ALERT, this.alert);
        request.setAttribute(SystemConstant.MESSAGE, this.message);
    }
}
