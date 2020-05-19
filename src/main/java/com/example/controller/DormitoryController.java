package com.example.controller;

import com.example.model.*;
import com.example.service.DormitoryService;
import com.example.service.EducationService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("audit")
public class DormitoryController {
    @Autowired
    private DormitoryService dormitoryService;

    @GetMapping("/dormitoryInfo")
    @RequiresPermissions("sys:stu:select")
    public Result findDormitoryByUsername(@RequestParam("user")String username) {
        return Result.success(dormitoryService.findByUsername(username));
    }

    @PutMapping("/dormitoryInfo")
    @RequiresPermissions("sys:user:shiro")
    public Result updateDormitoryStatus(@RequestBody Dormitory dormitory) {
        return dormitoryService.updateDormitoryStatus(dormitory);
    }

    @GetMapping("/dormitoryInfoList")
    @RequiresPermissions("sys:user:shiro")
    public Result findAllDormitory(@RequestParam(value = "status")Byte status,@RequestParam("stuId")Long stuId,@RequestParam("classId")Long classId,@RequestParam("dormitoryAuditResStatus")Byte dormitoryAuditResStatus) {
        return Result.success(dormitoryService.findByCondition(status,stuId,classId,dormitoryAuditResStatus));
    }

    @PostMapping("/dormitoryAuditRes")
    @RequiresPermissions("sys:user:shiro")
    public Result updateDormitoryAuditRes(@RequestBody DormitoryAuditRes dormitoryAuditRes){
        return dormitoryService.updateDormitoryAuditRes(dormitoryAuditRes);
    }
}
