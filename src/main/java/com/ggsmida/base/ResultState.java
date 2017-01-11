package com.ggsmida.base;

import org.apache.commons.lang.StringUtils;

/**
 * Created by junwuguo on 2017/1/10 0010.
 */
public enum ResultState {
    /**
     * if you need new result code, add it here and give it a good name
     */
    OK(200),
    SERVER_INTERNAL_ERROR(500),
    PARAM_ERROR(400),
    FORBIDDEN(403),
    NODE_NOT_REGISTERD(404),

    USER_LOGIN_ERROR(600),
    USER_REGISTER_ERROR(650),

    MAX_CODE(9999);

    //!!----------------do not modify code below------------------!!
    public final int resultCode;

    public <T> HttpResponseDiv<T> wrap(T resultObject) {
        return wrap(resultObject, null);
    }

    /**
     * wrap the result with a result code and result message
     * @param resultObject result object
     * @param resultMsg result message
     * @param <T> result type
     * @return HttpResponseDiv<T>
     */
    public <T> HttpResponseDiv<T> wrap(T resultObject, String resultMsg) {
        if (StringUtils.isBlank(resultMsg)) {
            resultMsg = "";
        }
        return new HttpResponseDiv<>(resultObject, this, resultMsg);
    }

    private ResultState(int code) {
        this.resultCode = code;
    }
}

