package com.example.controller;

import com.example.model.Result;
import com.example.service.AuditService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("audit")
public class AuditController {
    @Autowired
    private AuditService auditService;

    @GetMapping("/stuCardInfo")
    @RequiresPermissions("sys:user:shiro")
    public Result findStuCardByUsername(@RequestParam("user")String username) {
        return Result.success(auditService.findByUsername(username));
    }
}
