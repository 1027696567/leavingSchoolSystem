package com.example.service.impl;

import com.example.mapper.*;
import com.example.model.*;
import com.example.service.DormitoryService;
import com.example.service.ResultTranslate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
public class DormitoryServiceImpl implements DormitoryService {
    @Autowired
    private DormitoryMapper dormitoryMapper;
    @Autowired
    private ResultTranslate resultTranslate;
    @Autowired
    private DepartmentMapper departmentMapper;
    @Autowired
    private DormitoryAuditResMapper dormitoryAuditResMapper;
    @Override
    public List<DormitoryInfo> findByUsername(String username) {
        List<DormitoryInfo> dormitoryInfos = dormitoryMapper.selectByUsername(username);
        if (dormitoryInfos.size()>0){
            dormitoryInfos.forEach(dormitoryInfo -> {
                dormitoryInfo.setStatusName(resultTranslate.translateKeyStatus(dormitoryInfo.getStatus()));
                if (!Objects.isNull(dormitoryInfo.getReturnDate())) {
                    dormitoryInfo.setReturnDateName(DateFormat.getDateInstance().format(dormitoryInfo.getReturnDate()));
                }
                if (!Objects.isNull(dormitoryInfo.getDormitoryAuditResStatus())) {
                    dormitoryInfo.setAuditStatusName(resultTranslate.translateAuditStatus(dormitoryInfo.getDormitoryAuditResStatus()));
                }
            });

            return dormitoryInfos;
        } else {
            return null;
        }
    }

    @Override
    public Result updateDormitoryStatus(Dormitory dormitory) {
        if (Objects.isNull(dormitoryAuditResMapper.selectByDormitoryId(dormitory.getId()))) {
            DormitoryAuditRes dormitoryAuditRes = new DormitoryAuditRes();
            dormitoryAuditRes.setCreateTime(new Date());
            dormitoryAuditRes.setCreateUser(dormitory.getCreateUser());
            dormitoryAuditRes.setStuInfoId(dormitory.getStuInfoId());
            dormitoryAuditRes.setDormitoryId(dormitory.getId());
            dormitoryAuditRes.setStatus((byte) 0);
            dormitoryAuditResMapper.insertSelective(dormitoryAuditRes);
            return Result.success();
        } else {
            return Result.failure(ResultCode.SPECIFIED_QUESTIONED_USER_NOT_EXIST);
        }
    }

    @Override
    public List<DormitoryInfo> findByCondition(Byte status, Long stuId, Long classId, Byte dormitoryAuditResStatus) {
        List<DormitoryInfo> dormitoryInfos = dormitoryMapper.selectByCondition(status,stuId,classId,dormitoryAuditResStatus);
        dormitoryInfos.forEach(dormitoryInfo -> {
            dormitoryInfo.setStatusName(resultTranslate.translateKeyStatus(dormitoryInfo.getStatus()));
            if (!Objects.isNull(dormitoryInfo.getReturnDate())) {
                dormitoryInfo.setReturnDateName(DateFormat.getDateInstance().format(dormitoryInfo.getReturnDate()));
            }
            if (!Objects.isNull(dormitoryInfo.getDormitoryAuditResStatus())) {
                dormitoryInfo.setAuditStatusName(resultTranslate.translateAuditStatus(dormitoryInfo.getDormitoryAuditResStatus()));
            }
        });
        return dormitoryInfos;
    }

    @Override
    public Result updateDormitoryAuditRes(DormitoryAuditRes dormitoryAuditRes) {
        dormitoryAuditRes.setCreateTime(new Date());
        if (dormitoryAuditResMapper.updateByPrimaryKeySelective(dormitoryAuditRes) == 1) {
            return Result.success();
        } else {
            dormitoryAuditRes.setCreateTime(new Date());
            dormitoryAuditResMapper.insertSelective(dormitoryAuditRes);
            return Result.success();
        }
    }
}
