package com.example.controller;

import com.example.model.AuditRes;
import com.example.model.Information;
import com.example.model.Result;
import com.example.service.SystemService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@CrossOrigin
@RestController
@RequestMapping("/sys")
public class SystemController {

    @Autowired
    private SystemService systemService;

    @PostMapping("/information")
    @RequiresPermissions("sys:user:shiro")
    public Result addInformation(@RequestBody Information information) {
        return systemService.addInformation(information);
    }

    @GetMapping("/informations")
    @RequiresPermissions("sys:user:shiro")
    public Result findAllInformation() {
        return systemService.findAllInformation();
    }

    @GetMapping("/partInformation")
    @RequiresPermissions("sys:user:shiro")
    public Result findPartInformation(@RequestParam("title")String title,@RequestParam("status")byte status,@RequestParam("auditStatus")byte auditStatus) {
        return systemService.findByCondition(title,status,auditStatus);
    }

    @GetMapping("/information")
    @RequiresPermissions("sys:user:shiro")
    public Result findInformation(@RequestParam("id")Long id){
        return systemService.findById(id);
    }

    @PostMapping("/auditRes")
    @RequiresPermissions("sys:user:shiro")
    public Result auditInformation(@RequestBody AuditRes auditRes) {
        return systemService.auditInformation(auditRes);
    }

    @PutMapping("/information")
    @RequiresPermissions("sys:user:shiro")
    public Result updateInformation(@RequestBody Information information) {
        return systemService.updateInformation(information);
    }

    @PutMapping("/informationStatus")
    @RequiresPermissions("sys:user:shiro")
    public Result updateInformationStatus(@RequestBody Information information) {
        return systemService.updateInformationStatus(information);
    }

    @GetMapping("/auditRes")
    @RequiresPermissions("sys:user:shiro")
    public Result findAuditResByInformationId(@RequestParam("id")Long id) {
        return Result.success(systemService.findAuditResByInformationId(id));
    }
}
