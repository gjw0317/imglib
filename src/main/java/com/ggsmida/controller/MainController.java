package com.ggsmida.controller;

import com.ggsmida.beans.User;
import com.ggsmida.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * Created by junwuguo on 2017/1/6 0006.
 */
@Controller
public class MainController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String root() throws Exception {
        return "auth/login";
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() throws Exception {
        return "index/index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() throws Exception {
        return "auth/login";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register() throws Exception {
        return "auth/register";
    }
}