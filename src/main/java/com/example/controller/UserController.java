package com.example.controller;

import com.example.model.Result;
import com.example.service.ShiroService;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.Subject;
import javax.servlet.http.HttpServletResponse;
import java.io.Serializable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author chen
 * @program leavingSchoolSystem
 * @description 用户操作控制器
 * @create 2020-04-04 10:00
 */
@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private ShiroService shiroService;

    @GetMapping("/login")
    public Result userLogin(@RequestParam(value = "userName") String userName, @RequestParam(value = "passWord") String passWord) {
        Map<String,Object> map = new HashMap<>(16);
        map.put("token",shiroService.userLogin(userName,passWord));
        map.put("menu",shiroService.getMenu());
        return Result.success(map);
    }
}
