package com.example.controller;

import com.example.model.*;
import com.example.service.LibraryCardService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("audit")
public class LibraryCardController {
    @Autowired
    private LibraryCardService libraryCardService;

    @GetMapping("/libraryCardInfo")
    @RequiresPermissions("sys:stu:select")
    public Result findLibraryCardByUsername(@RequestParam("user")String username) {
        return Result.success(libraryCardService.findByUsername(username));
    }

    @PutMapping("/libraryCardInfo")
    @RequiresPermissions("sys:user:shiro")
    public Result updateLibraryCardStatus(@RequestBody LibraryCard libraryCard) {
        return libraryCardService.updateLibraryCardStatus(libraryCard);
    }

    @GetMapping("/libraryCardInfoList")
    @RequiresPermissions("sys:user:shiro")
    public Result findAllStuCard(@RequestParam(value = "status")Byte status,@RequestParam("stuId")Long stuId,@RequestParam("classId")Long classId,@RequestParam("libraryCardAuditResStatus")Byte libraryCardAuditResStatus) {
        return Result.success(libraryCardService.findByCondition(status,stuId,classId,libraryCardAuditResStatus));
    }

    @PostMapping("/libraryCardAuditRes")
    @RequiresPermissions("sys:user:shiro")
    public Result updateLibraryCardAuditRes(@RequestBody LibraryCardAuditRes libraryCardAuditRes){
        return libraryCardService.updateLibraryCardAuditRes(libraryCardAuditRes);
    }
}
