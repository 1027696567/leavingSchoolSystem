package com.example.controller;

import com.example.model.*;
import com.example.service.PartyBranchService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("audit")
public class PartyBranchController {
    @Autowired
    private PartyBranchService partyBranchService;

    @GetMapping("/partyBranchInfo")
    @RequiresPermissions("sys:stu:select")
    public Result findPartyBranchByUsername(@RequestParam("user")String username) {
        return Result.success(partyBranchService.findByUsername(username));
    }

    @PutMapping("/partyBranchInfo")
    @RequiresPermissions("sys:user:shiro")
    public Result updatePartyBranchStatus(@RequestBody PartyBranch partyBranch) {
        return partyBranchService.updatePartyBranchStatus(partyBranch);
    }

    @GetMapping("/partyBranchInfoList")
    @RequiresPermissions("sys:user:shiro")
    public Result findAllPartyBranch(@RequestParam(value = "status")Byte status,@RequestParam("stuId")Long stuId,@RequestParam("classId")Long classId,@RequestParam("partyBranchAuditResStatus")Byte partyBranchAuditResStatus) {
        return Result.success(partyBranchService.findByCondition(status,stuId,classId,partyBranchAuditResStatus));
    }

    @PostMapping("/partyBranchAuditRes")
    @RequiresPermissions("sys:user:shiro")
    public Result updatePartyBranchAuditRes(@RequestBody PartyBranchAuditRes partyBranchAuditRes){
        return partyBranchService.updatePartyBranchAuditRes(partyBranchAuditRes);
    }
}
