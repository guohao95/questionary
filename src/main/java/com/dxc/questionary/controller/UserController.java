package com.dxc.questionary.controller;

import com.dxc.questionary.config.JSONResult;
import com.dxc.questionary.config.constant.Constant;
import com.dxc.questionary.entity.TokenVO;
import com.dxc.questionary.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author huang
 */
@RestController
@RequestMapping("/user")
@Api(tags = "用户集合")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/login")
    @ApiOperation(value = "用户注册")
    public JSONResult login(@RequestParam @ApiParam(value = "用户名", name = "username") String username,
                            @RequestParam @ApiParam(value = "密码/手机号码", name = "password") String password) {
        if (username.equals(null) || password.equals(null)) {
            return JSONResult.Failed(Constant.LOGIN_ERROR, null);
        }
        TokenVO login = userService.login(username, password);
        if (login != null) {
            return JSONResult.Ok(Constant.LOGIN_SUCCESS, login);
        } else {
            return JSONResult.Failed("登录失败", null);
        }
    }

    @PostMapping("/resetPwd")
    @ApiOperation(value = "重置密码")
    public JSONResult reset(@RequestParam @ApiParam(value = "用户名", name = "username") String username,
                            @RequestParam @ApiParam(value = "密码/手机号码", name = "password") String password) {
        if (username.equals("") || username.equals(null)) {
            return JSONResult.Failed(Constant.LOGIN_ERROR, null);
        }
        if (userService.resetPassword(username, password)) {
            return JSONResult.OK();
        } else {
            return JSONResult.Error();
        }
    }
}
