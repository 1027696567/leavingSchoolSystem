package com.example.controller;

import com.example.model.Result;
import com.example.model.StuCard;
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
    @RequiresPermissions("sys:stu:select")
    public Result findStuCardByUsername(@RequestParam("user")String username) {
        return Result.success(auditService.findByUsername(username));
    }

    @PutMapping("/stuCardInfo")
    @RequiresPermissions("sys:user:shiro")
    public Result updateStuCardStatus(@RequestBody StuCard stuCard) {
        return auditService.updateStuCardStatus(stuCard);
    }

    @GetMapping("/stuCardInfoList")
    @RequiresPermissions("sys:user:shiro")
    public Result findAllStuCard(@RequestParam("status")Byte status,@RequestParam("stuId")Long stuId,@RequestParam("classId")Long classId) {
        return Result.success(auditService.findByCondition(status,stuId,classId));
    }

}
