package com.example.controller;

import com.example.model.*;
import com.example.service.CollegeCardService;
import com.example.service.LibraryCardService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("audit")
public class CollegeCardController {
    @Autowired
    private CollegeCardService collegeCardService;

    @GetMapping("/collegeCardInfo")
    @RequiresPermissions("sys:stu:select")
    public Result findCollegeCardByUsername(@RequestParam("user")String username) {
        return Result.success(collegeCardService.findByUsername(username));
    }

    @PutMapping("/collegeCardInfo")
    @RequiresPermissions("sys:user:shiro")
    public Result updateCollegeCardStatus(@RequestBody CollegeCard collegeCard) {
        return collegeCardService.updateCollegeCardStatus(collegeCard);
    }

    @GetMapping("/collegeCardInfoList")
    @RequiresPermissions("sys:user:shiro")
    public Result findAllCollegeCard(@RequestParam(value = "status")Byte status,@RequestParam("stuId")Long stuId,@RequestParam("classId")Long classId,@RequestParam("collegeCardAuditResStatus")Byte collegeCardAuditResStatus) {
        return Result.success(collegeCardService.findByCondition(status,stuId,classId,collegeCardAuditResStatus));
    }

    @PostMapping("/collegeCardAuditRes")
    @RequiresPermissions("sys:user:shiro")
    public Result updateCollegeCardAuditRes(@RequestBody CollegeCardAuditRes collegeCardAuditRes){
        return collegeCardService.updateCollegeCardAuditRes(collegeCardAuditRes);
    }
}
