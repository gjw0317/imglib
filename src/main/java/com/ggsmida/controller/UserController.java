package com.ggsmida.controller;

import com.ggsmida.base.HttpResponseDiv;
import com.ggsmida.service.auth.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by junwuguo on 2017/1/9 0009.
 */
@Controller
@RequestMapping("/api/account")
public class UserController {

    @Autowired
    UserService userService;

    @ResponseBody
    @RequestMapping(value = "/{email}/check", method = RequestMethod.POST)
    public HttpResponseDiv<?> checkAccount(@PathVariable String email, @RequestBody String loginModel) throws Exception {
        return userService.checkAccount(loginModel);
    }

    @ResponseBody
    @RequestMapping(value = "/{email}/add", method = RequestMethod.POST)
    public HttpResponseDiv<?> addAccount(@PathVariable String email, @RequestBody String registerModel) throws Exception {
        return userService.addAccount(registerModel);
    }
}
