package com.example.service.impl;

import com.example.mapper.*;
import com.example.model.*;
import com.example.service.EducationService;
import com.example.service.ResultTranslate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
public class EducationServiceImpl implements EducationService {
    @Autowired
    private EducationMapper educationMapper;
    @Autowired
    private ResultTranslate resultTranslate;
    @Autowired
    private DepartmentMapper departmentMapper;
    @Autowired
    private EducationAuditResMapper educationAuditResMapper;
    @Override
    public List<EducationInfo> findByUsername(String username) {
        List<EducationInfo> educationInfos = educationMapper.selectByUsername(username);
        if (educationInfos.size()>0){
            educationInfos.forEach(educationInfo -> {
                educationInfo.setPayStatus(resultTranslate.translatePayStatus(educationInfo.getStatus()));
                //stuCardInfo.setTranslateReissueDate(DateFormat.getDateInstance().format(stuCardInfo.getReissueDate()));
                if (!Objects.isNull(educationInfo.getEducationAuditResStatus())) {
                    educationInfo.setAuditStatusName(resultTranslate.translateAuditStatus(educationInfo.getEducationAuditResStatus()));
                }
            });

            return educationInfos;
        } else {
            return null;
        }
    }

    @Override
    public Result updateEducationStatus(Education education) {
        if (Objects.isNull(educationAuditResMapper.selectByEducationId(education.getId()))) {
            EducationAuditRes educationAuditRes = new EducationAuditRes();
            educationAuditRes.setCreateTime(new Date());
            educationAuditRes.setCreateUser(education.getCreateUser());
            educationAuditRes.setStuInfoId(education.getStuInfoId());
            educationAuditRes.setEducationId(education.getId());
            educationAuditRes.setStatus((byte) 0);
            educationAuditResMapper.insertSelective(educationAuditRes);
            return Result.success();
        } else {
            return Result.failure(ResultCode.SPECIFIED_QUESTIONED_USER_NOT_EXIST);
        }
    }

    @Override
    public List<EducationInfo> findByCondition(Byte status, Long stuId, Long classId, Byte educationAuditResStatus) {
        List<EducationInfo> educationInfos = educationMapper.selectByCondition(status,stuId,classId,educationAuditResStatus);
        educationInfos.forEach(educationInfo -> {
            educationInfo.setPayStatus(resultTranslate.translatePayStatus(educationInfo.getStatus()));
            //stuCardInfo.setTranslateReissueDate(DateFormat.getDateInstance().format(stuCardInfo.getReissueDate()));
            if (!Objects.isNull(educationInfo.getEducationAuditResStatus())) {
                educationInfo.setAuditStatusName(resultTranslate.translateAuditStatus(educationInfo.getEducationAuditResStatus()));
            }
        });
        return educationInfos;
    }

    @Override
    public Result updateEducationAuditRes(EducationAuditRes educationAuditRes) {
        educationAuditRes.setCreateTime(new Date());
        if (educationAuditResMapper.updateByPrimaryKeySelective(educationAuditRes) == 1) {
            return Result.success();
        } else {
            educationAuditRes.setCreateTime(new Date());
            educationAuditResMapper.insertSelective(educationAuditRes);
            return Result.success();
        }
    }
}
