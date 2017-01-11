package com.ggsmida.service.auth;

import com.ggsmida.base.HttpResponseDiv;

/**
 * Created by junwuguo on 2017/1/9 0009.
 */
public interface UserService {

    public HttpResponseDiv<?> checkAccount(String loginModel);

    public HttpResponseDiv<?> addAccount(String registerModel);
}
