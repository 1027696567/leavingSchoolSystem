package com.example.service.impl;

import com.example.mapper.*;
import com.example.model.*;
import com.example.service.MinistryFinanceService;
import com.example.service.ResultTranslate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
public class MinistryFinanceServiceImpl implements MinistryFinanceService {
    @Autowired
    private MinistryFinanceMapper ministryFinanceMapper;
    @Autowired
    private ResultTranslate resultTranslate;
    @Autowired
    private DepartmentMapper departmentMapper;
    @Autowired
    private MinistryFinanceAuditResMapper ministryFinanceAuditResMapper;
    @Override
    public List<MinistryFinanceInfo> findByUsername(String username) {
        List<MinistryFinanceInfo> ministryFinanceInfos = ministryFinanceMapper.selectByUsername(username);
        if (ministryFinanceInfos.size()>0){
            ministryFinanceInfos.forEach(ministryFinanceInfo -> {
                ministryFinanceInfo.setPayStatus(resultTranslate.translatePayStatus(ministryFinanceInfo.getStatus()));
                //stuCardInfo.setTranslateReissueDate(DateFormat.getDateInstance().format(stuCardInfo.getReissueDate()));
                if (!Objects.isNull(ministryFinanceInfo.getMinistryFinanceAuditResStatus())) {
                    ministryFinanceInfo.setAuditStatusName(resultTranslate.translateAuditStatus(ministryFinanceInfo.getMinistryFinanceAuditResStatus()));
                }
            });

            return ministryFinanceInfos;
        } else {
            return null;
        }
    }

    @Override
    public Result updateMinistryFinanceStatus(MinistryFinance ministryFinance) {
        if (Objects.isNull(ministryFinanceAuditResMapper.selectByMinistryFinanceId(ministryFinance.getId()))) {
            MinistryFinanceAuditRes ministryFinanceAuditRes = new MinistryFinanceAuditRes();
            ministryFinanceAuditRes.setCreateTime(new Date());
            ministryFinanceAuditRes.setCreateUser(ministryFinance.getCreateUser());
            ministryFinanceAuditRes.setStuInfoId(ministryFinance.getStuInfoId());
            ministryFinanceAuditRes.setMinistryFinanceId(ministryFinance.getId());
            ministryFinanceAuditRes.setStatus((byte) 0);
            ministryFinanceAuditResMapper.insertSelective(ministryFinanceAuditRes);
            return Result.success();
        } else {
            return Result.failure(ResultCode.SPECIFIED_QUESTIONED_USER_NOT_EXIST);
        }
    }

    @Override
    public List<MinistryFinanceInfo> findByCondition(Byte status, Long stuId, Long classId, Byte ministryFinanceAuditResStatus) {
        List<MinistryFinanceInfo> ministryFinanceInfos = ministryFinanceMapper.selectByCondition(status,stuId,classId,ministryFinanceAuditResStatus);
        ministryFinanceInfos.forEach(ministryFinanceInfo -> {
            ministryFinanceInfo.setPayStatus(resultTranslate.translatePayStatus(ministryFinanceInfo.getStatus()));
            //stuCardInfo.setTranslateReissueDate(DateFormat.getDateInstance().format(stuCardInfo.getReissueDate()));
            if (!Objects.isNull(ministryFinanceInfo.getMinistryFinanceAuditResStatus())) {
                ministryFinanceInfo.setAuditStatusName(resultTranslate.translateAuditStatus(ministryFinanceInfo.getMinistryFinanceAuditResStatus()));
            }
        });
        return ministryFinanceInfos;
    }

    @Override
    public Result updateMinistryFinanceAuditRes(MinistryFinanceAuditRes ministryFinanceAuditRes) {
        ministryFinanceAuditRes.setCreateTime(new Date());
        if (ministryFinanceAuditResMapper.updateByPrimaryKeySelective(ministryFinanceAuditRes) == 1) {
            return Result.success();
        } else {
            ministryFinanceAuditRes.setCreateTime(new Date());
            ministryFinanceAuditResMapper.insertSelective(ministryFinanceAuditRes);
            return Result.success();
        }
    }
}
