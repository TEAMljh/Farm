package com.ljh.farm.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ljh.farm.entity.User;
import com.ljh.farm.service.UserService;
import com.ljh.farm.util.LayUIResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @Description
 * @Author ljh
 * @Date 2020/3/9 17:20
 */
@RestController
@RequestMapping("main")
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping("login")
    public Object login(User user, HttpServletRequest request) {
        QueryWrapper<User> queryWrapper = new QueryWrapper();
        if (user != null) {
            String name = user.getName();
            String pass = user.getPass();
            queryWrapper.eq("name", name).eq("pass", pass);
            User user1 = userService.getOne(queryWrapper);
            HttpSession session = request.getSession();
            if (user1 != null) {
                session.setAttribute("user", user1);
                session.setMaxInactiveInterval(30 * 60);
//                return LayUIResult.ok("登陆成功");
                return new LayUIResult(0, "登陆成功", user1);
            } else {
                return LayUIResult.error("用户名或密码错误!");
            }

        } else {
            return LayUIResult.error("登陆失败");
        }
    }

    @GetMapping("login/register")
    public Object regist(User user) {
        User user1 = userService.getOne(new QueryWrapper<User>().eq("name", user.getName()));

        if (user1.getName().equals(user.getName())) {
            return LayUIResult.error("该用户已存在！");
        } else {
            userService.save(user);
            return LayUIResult.ok("注册成功！");
        }
    }

    @GetMapping("changeUser")
    public Object changeUserInfo(User user) {
        if (userService.updateById(user)) {
            return LayUIResult.ok("更改成功");
        } else {
            return LayUIResult.error("更改失败");
        }
    }
}
