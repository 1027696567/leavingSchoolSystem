package com.example.service.impl;

import com.example.mapper.AuditResMapper;
import com.example.mapper.InformationMapper;
import com.example.mapper.SysRoleMapper;
import com.example.model.*;
import com.example.service.ResultTranslate;
import com.example.service.SystemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
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

    @Autowired
    AuditResMapper auditResMapper;

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
                    information.setUpdateTimeToString(DateFormat.getDateTimeInstance().format(information.getUpdateTime()));
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
                    information.setUpdateTimeToString(DateFormat.getDateTimeInstance().format(information.getUpdateTime()));
                });
        return Result.success(informationList);
    }

    @Override
    public Result findById(Long id) {
        Information information = informationMapper.selectById(id);
        information.setUpdateTimeToString(DateFormat.getDateTimeInstance().format(information.getUpdateTime()));
        return Result.success(information);
    }

    @Override
    public Result auditInformation(AuditRes auditRes) {
        try {
            AuditRes auditRes1 = auditResMapper.selectByInformationId(auditRes.getInformationId());
            auditRes1.setContent(auditRes.getContent());
            auditRes1.setUpdateUser(auditRes.getCreateUser());
            auditRes1.setUpdateTime(new Date());
            auditResMapper.updateByPrimaryKeySelective(auditRes1);
        } catch (Exception e) {
            auditRes.setActive((byte) 1);
            auditRes.setCreateTime(new Date());
            auditResMapper.insertSelective(auditRes);
        } finally {
            Information information = new Information();
            information.setId(auditRes.getInformationId());
            information.setUpdateTime(new Date());
            information.setAuditStatus((byte) (auditRes.getContent().equals("")?1:-1));
            informationMapper.updateByPrimaryKeySelective(information);
            return Result.success();
        }
    }

    @Override
    public Result updateInformation(Information information) {
        information.setAuditStatus((byte) 0);
        information.setUpdateTime(new Date());
        informationMapper.updateByPrimaryKeySelective(information);
        return Result.success();
    }

    @Override
    public Result updateInformationStatus(Information information) {
        information.setUpdateTime(new Date());
        informationMapper.updateByPrimaryKeySelective(information);
        return Result.success();
    }

    @Override
    public AuditRes findAuditResByInformationId(Long id) {
        return auditResMapper.selectByInformationId(id);
    }


}
