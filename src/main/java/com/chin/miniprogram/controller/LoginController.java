package com.chin.miniprogram.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.chin.miniprogram.common.JsonData;
import com.chin.miniprogram.entity.Account;
import com.chin.miniprogram.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Wrapper;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author chinZh
 * @since 2020-05-30
 */
@RestController

@CrossOrigin
public class LoginController {
    @Autowired
    private AccountService accountService;

    @RequestMapping(value = "/miniprogram/login", method = RequestMethod.POST)
    public JsonData login(@RequestParam("username") String username, @RequestParam("password") String password){
        JsonData jsonData = new JsonData();
        if ("".equals(username)){
            jsonData.setReturnCode(1);
            jsonData.setReturnMessage("用户名不能为空！");
            return jsonData;
        }else if ("".equals(password)){
            jsonData.setReturnCode(1);
            jsonData.setReturnMessage("密码不能为空！");
            return jsonData;
        }
        Account account = accountService.getAccount(username, password);
        if (account != null){
            jsonData.setReturnCode(0);
            jsonData.setReturnMessage("登录成功");
            return jsonData;
        }else {
            jsonData.setReturnCode(1);
            jsonData.setReturnMessage("用户名或密码错误，请重新输入");
            return jsonData;
        }

    }
}

