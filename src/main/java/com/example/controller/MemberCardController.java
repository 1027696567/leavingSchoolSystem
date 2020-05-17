package com.example.controller;

import com.example.model.*;
import com.example.service.AuditService;
import com.example.service.MemberCardService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("audit")
public class MemberCardController {
    @Autowired
    private MemberCardService memberCardService;

    @GetMapping("/memberCardInfo")
    @RequiresPermissions("sys:stu:select")
    public Result findMemberCardByUsername(@RequestParam("user")String username) {
        return Result.success(memberCardService.findByUsername(username));
    }

    @PutMapping("/memberCardInfo")
    @RequiresPermissions("sys:user:shiro")
    public Result updateMemberCardStatus(@RequestBody MemberCard memberCard) {
        return memberCardService.updateMemberCardStatus(memberCard);
    }

    @GetMapping("/memberCardInfoList")
    @RequiresPermissions("sys:user:shiro")
    public Result findAllStuCard(@RequestParam(value = "status")Byte status,@RequestParam("stuId")Long stuId,@RequestParam("classId")Long classId,@RequestParam("memberCardAuditResStatus")Byte memberCardAuditResStatus) {
        return Result.success(memberCardService.findByCondition(status,stuId,classId,memberCardAuditResStatus));
    }

    @PostMapping("/memberCardAuditRes")
    @RequiresPermissions("sys:user:shiro")
    public Result updateMemberCardAuditRes(@RequestBody MemberCardAuditRes memberCardAuditRes){
        return memberCardService.updateMemberCardAuditRes(memberCardAuditRes);
    }
}
