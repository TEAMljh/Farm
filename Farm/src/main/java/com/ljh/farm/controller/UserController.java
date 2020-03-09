package com.ljh.farm.controller;

import com.ljh.farm.service.UserService;
import com.ljh.farm.util.LayUIResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author ljh
 * @Date 2020/3/9 17:12
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("getUser")
    public Object getUser() {
        return LayUIResult.ok(userService.getById(1));
    }
}
