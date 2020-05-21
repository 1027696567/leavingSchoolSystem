package com.example.controller;

import com.example.model.FinalAuditRes;
import com.example.model.Result;
import com.example.service.FinalAuditResService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("audit")
public class FinalAuditResController {
    @Autowired
    private FinalAuditResService finalAuditResService;

    @GetMapping("/listFinalAuditRes")
    @RequiresPermissions("sys:user:shiro")
    public Result findAllFinalAuditRes() {
        return Result.success(finalAuditResService.findAllFinalAuditResInfo());
    }

    @PostMapping("/finalAuditRes")
    @RequiresPermissions("sys:user:shiro")
    public Result updateFinalAuditRes(@RequestBody FinalAuditRes finalAuditRes) {
        return Result.success(finalAuditResService.updateFinalAuditRes(finalAuditRes));
    }

    @GetMapping("/finalAuditRes")
    @RequiresPermissions("sys:user:shiro")
    public Result findByUsername(@RequestParam("user")String username) {
        return Result.success(finalAuditResService.findByCondition(username));
    }
}
