package com.example.controller;

import com.example.model.*;
import com.example.service.MinistryFinanceService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("audit")
public class MinistryFinanceController {
    @Autowired
    private MinistryFinanceService ministryFinanceService;

    @GetMapping("/ministryFinanceInfo")
    @RequiresPermissions("sys:stu:select")
    public Result findMinistryFinanceByUsername(@RequestParam("user")String username) {
        return Result.success(ministryFinanceService.findByUsername(username));
    }

    @PutMapping("/ministryFinanceInfo")
    @RequiresPermissions("sys:user:shiro")
    public Result updatemMinistryFinanceStatus(@RequestBody MinistryFinance ministryFinance) {
        return ministryFinanceService.updateMinistryFinanceStatus(ministryFinance);
    }

    @GetMapping("/ministryFinanceInfoList")
    @RequiresPermissions("sys:user:shiro")
    public Result findAllMinistryFinance(@RequestParam(value = "status")Byte status,@RequestParam("stuId")Long stuId,@RequestParam("classId")Long classId,@RequestParam("ministryFinanceAuditResStatus")Byte ministryFinanceAuditResStatus) {
        return Result.success(ministryFinanceService.findByCondition(status,stuId,classId,ministryFinanceAuditResStatus));
    }

    @PostMapping("/ministryFinanceAuditRes")
    @RequiresPermissions("sys:user:shiro")
    public Result updateMinistryFinanceAuditRes(@RequestBody MinistryFinanceAuditRes ministryFinanceAuditRes){
        return ministryFinanceService.updateMinistryFinanceAuditRes(ministryFinanceAuditRes);
    }
}
