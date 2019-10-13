package com.programmingjavaweb.utils.message;

import javax.servlet.http.HttpServletRequest;

public interface MessageUtils {

    void buildMessage(HttpServletRequest request);

    static MessageUtils of(String message, String alert) {
        return new MessageUtilsImpl(message, alert);
    }
}
