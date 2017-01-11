package com.ggsmida.service.auth.impl;

import com.ggsmida.base.Constant;
import com.ggsmida.base.HttpResponseDiv;
import com.ggsmida.base.ResultState;
import com.ggsmida.beans.User;
import com.ggsmida.mapper.UserMapper;
import com.ggsmida.service.auth.UserService;
import com.ggsmida.util.Base64;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by junwuguo on 2017/1/9 0009.
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    Logger logger = Logger.getLogger(UserServiceImpl.class);

    @Autowired
    UserMapper userMapper;

    @Override
    public HttpResponseDiv<?> checkAccount(String loginModel) {
        try {
            if (StringUtils.isBlank(loginModel))
                return ResultState.USER_LOGIN_ERROR.wrap(null, "登陆失败！请检查邮箱、密码是否为空！");

            JSONObject json = new JSONObject(loginModel);
            if (json.has("email") && json.has("password")) {
                User user = userMapper.findUserByEmailPwd(json.getString("email").trim(), Base64.encode(json.getString("password").trim()));
                if (null == user) {
                    return ResultState.USER_LOGIN_ERROR.wrap(null, "登陆失败！邮箱或密码错误，请重试！");
                }
                logger.info("登陆成功：" + json.getString("email"));
            } else {
                return ResultState.USER_LOGIN_ERROR.wrap(null, "登陆失败！请检查邮箱、密码是否为空！");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResultState.OK.wrap(null, "登陆成功！");
    }

    @Override
    public HttpResponseDiv<?> addAccount(String registerModel) {
        try {
            if (StringUtils.isBlank(registerModel))
                return ResultState.USER_REGISTER_ERROR.wrap(null, "注册失败！请检查用户名、邮箱、密码是否为空！");

            JSONObject json = new JSONObject(registerModel);
            Date currentTime = new Date();
            Date birth_date = Constant.getDefaultBirthDate();
            if (json.has("nick_name") && json.has("email") && json.has("password")) {
                userMapper.insertUser(json.getString("email").trim(),
                        json.getString("nick_name").trim(),
                        Base64.encode(json.getString("password").trim()),
                        birth_date,
                        currentTime,
                        currentTime);
                logger.info("注册成功：" + json.getString("email"));
            } else {
                return ResultState.USER_REGISTER_ERROR.wrap(null, "注册失败！请检查用户名、邮箱、密码是否为空！");
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("注册异常：" + e.getMessage());
        }
        return ResultState.OK.wrap(null, "注册成功！");
    }
}
