package com.chin.miniprogram.controller;


import com.chin.miniprogram.common.JsonData;
import com.chin.miniprogram.entity.User;
import com.chin.miniprogram.service.UserService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author chinZh
 * @since 2020-05-30
 */
@RestController
@RequestMapping("/miniprogram/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/insert")
    public JsonData insertUser(@RequestBody User user) {
        JsonData jsonData = new JsonData();
        boolean save = userService.save(user);
        if (save) {
            jsonData.setReturnCode(0);
            jsonData.setReturnMessage("新增成功");
        } else {
            jsonData.setReturnCode(1);
            jsonData.setReturnMessage("新增失败");
        }
        return jsonData;
    }

    @PutMapping("/update")
    public JsonData updateUser(@RequestBody User user) {
        JsonData jsonData = new JsonData();
        boolean b = userService.updateById(user);
        if (b){
            jsonData.setReturnCode(0);
            jsonData.setReturnMessage("更新成功");
        }else {
            jsonData.setReturnCode(0);
            jsonData.setReturnMessage("更新失败");
        }
        return jsonData;
    }

    @GetMapping("/getAll")
    public JsonData getAllUser(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo, @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize) {
        JsonData jsonData = new JsonData();
        List<User> list = userService.list(pageNo, pageSize);
        if (list != null && list.size() > 0) {
            jsonData.setReturnCode(0);
            jsonData.setData(list);
            jsonData.setReturnMessage("查询成功");
        } else {
            jsonData.setReturnCode(0);
            jsonData.setData(list);
            jsonData.setReturnMessage("未查询到数据");
        }
        return jsonData;
    }
    @GetMapping("/getById/{id}")
    public JsonData getAllUser(@PathVariable("id") Integer id) {
        JsonData jsonData = new JsonData();
        User user = userService.getById(id);
        if (user != null) {
            jsonData.setReturnCode(0);
            jsonData.setData(user);
            jsonData.setReturnMessage("查询成功");
        } else {
            jsonData.setReturnCode(0);
            jsonData.setData(user);
            jsonData.setReturnMessage("未查询到数据");
        }
        return jsonData;
    }

    @DeleteMapping("/deleteById/{id}")
    public JsonData deleteUser(@PathVariable("id") Integer id) {
        JsonData jsonData = new JsonData();
        boolean b = userService.removeById(id);
        if (b) {
            jsonData.setReturnCode(0);
            jsonData.setReturnMessage("删除成功");
        } else {
            jsonData.setReturnCode(0);
            jsonData.setReturnMessage("删除失败");
        }
        return jsonData;
    }
}

