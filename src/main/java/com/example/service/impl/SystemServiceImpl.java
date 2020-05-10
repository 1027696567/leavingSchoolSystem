package com.example.service.impl;

import com.example.mapper.InformationMapper;
import com.example.mapper.SysRoleMapper;
import com.example.model.Information;
import com.example.model.Result;
import com.example.model.ResultCode;
import com.example.model.SysRole;
import com.example.service.ResultTranslate;
import com.example.service.SystemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class SystemServiceImpl implements SystemService {

    @Autowired
    InformationMapper informationMapper;

    @Autowired
    SysRoleMapper sysRoleMapper;

    @Autowired
    ResultTranslate resultTranslate;

    @Override
    public Result addInformation(Information information) {
        List<SysRole> sysRoleList = sysRoleMapper.selectByUserName(information.getCreateUser());
        information.setAuditStatus((byte) 0);
        information.setActive((byte) 1);
        information.setCreateTime(new Date());
        information.setUpdateTime(new Date());
        information.setDeptId(sysRoleList.get(0).getDeptId());
        information.setStatus((byte) -1);
        if (informationMapper.insertSelective(information) != 0) {
            return Result.success();
        } else {
            return Result.failure(ResultCode.SPECIFIED_QUESTIONED_USER_NOT_EXIST);
        }
    }

    @Override
    public Result findAllInformation() {
        List<Information> informationList = informationMapper.selectAll();
        informationList.forEach(
                information ->
                {
                    information.setActiveName(resultTranslate.translateActive(information.getActive()));
                    information.setStatusName(resultTranslate.translateStatus(information.getStatus()));
                    information.setAuditStatusName(resultTranslate.translateAuditStatus(information.getAuditStatus()));
                });
        return Result.success(informationList);
    }

    @Override
    public Result findByCondition(String title, byte status, byte auditStatus) {
        List<Information> informationList = informationMapper.selectByCondition(title,status,auditStatus);
                informationList.forEach(
                information ->
                {
                    information.setActiveName(resultTranslate.translateActive(information.getActive()));
                    information.setStatusName(resultTranslate.translateStatus(information.getStatus()));
                    information.setAuditStatusName(resultTranslate.translateAuditStatus(information.getAuditStatus()));
                });
        return Result.success(informationList);
    }

    @Override
    public Result findById(Long id) {
        return Result.success(informationMapper.selectById(id));
    }

    @Override
    public Result auditInformation(Information information) {
        informationMapper.updateByPrimaryKeySelective(information);
        return Result.success();
    }
}
