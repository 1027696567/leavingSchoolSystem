package com.example.controller;

import com.example.model.*;
import com.example.service.EducationService;
import com.example.service.LibraryCardService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("audit")
public class EducationController {
    @Autowired
    private EducationService educationService;

    @GetMapping("/educationInfo")
    @RequiresPermissions("sys:stu:select")
    public Result findEducationByUsername(@RequestParam("user")String username) {
        return Result.success(educationService.findByUsername(username));
    }

    @PutMapping("/educationInfo")
    @RequiresPermissions("sys:user:shiro")
    public Result updateEducationStatus(@RequestBody Education education) {
        return educationService.updateEducationStatus(education);
    }

    @GetMapping("/educationInfoList")
    @RequiresPermissions("sys:user:shiro")
    public Result findAllEducation(@RequestParam(value = "status")Byte status,@RequestParam("stuId")Long stuId,@RequestParam("classId")Long classId,@RequestParam("educationAuditResStatus")Byte educationAuditResStatus) {
        return Result.success(educationService.findByCondition(status,stuId,classId,educationAuditResStatus));
    }

    @PostMapping("/educationAuditRes")
    @RequiresPermissions("sys:user:shiro")
    public Result updateEducationAuditRes(@RequestBody EducationAuditRes educationAuditRes){
        return educationService.updateEducationAuditRes(educationAuditRes);
    }
}
