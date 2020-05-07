package com.example.controller;

import com.example.model.Information;
import com.example.model.Result;
import com.example.service.SystemService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@CrossOrigin
@RestController
@RequestMapping("/sys")
public class SystemController {

    @Autowired
    private SystemService systemService;

    @PostMapping("/information")
    @RequiresPermissions("sys:user:shiro")
    public Result addInformation(@RequestBody Information information) {
        return systemService.addInformation(information);
    }

    @GetMapping("/information")
    @RequiresPermissions("sys:user:shiro")
    public Result findAllInformation() {
        return systemService.findAllInformation();
    }
}
