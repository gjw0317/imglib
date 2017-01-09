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
    @Autowired
    UserMapper userMapper;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() throws Exception {
        User user = userMapper.findUserById(2);
        System.out.println("#" + user.getNick_name());
        return "index";
    }
}