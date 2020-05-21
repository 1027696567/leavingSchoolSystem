package com.example.service.impl;

import com.example.mapper.FinalAuditResMapper;
import com.example.model.FinalAuditRes;
import com.example.model.FinalAuditResInfo;
import com.example.model.Result;
import com.example.model.ResultCode;
import com.example.service.FinalAuditResService;
import com.example.service.ResultTranslate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
public class FinalAuditResServiceImpl implements FinalAuditResService {
    @Autowired
    private FinalAuditResMapper finalAuditResMapper;
    @Autowired
    private ResultTranslate resultTranslate;
    @Override
    public List<FinalAuditResInfo> findByCondition(String username) {
        List<FinalAuditResInfo> finalAuditResInfos = finalAuditResMapper.selectByCondition(username);
        finalAuditResInfos.forEach(finalAuditResInfo -> {
            if (!Objects.isNull(finalAuditResInfo.getDormitoryAuditResStatus())) {
                finalAuditResInfo.setDormitoryAuditResStatusName(resultTranslate.translateAuditStatus(finalAuditResInfo.getDormitoryAuditResStatus()));
            } else {
                finalAuditResInfo.setDormitoryAuditResStatusName("未提交审核");
            }
            if (!Objects.isNull(finalAuditResInfo.getCollegeCardAuditResStatus())) {
                finalAuditResInfo.setCollegeCardAuditResStatusName(resultTranslate.translateAuditStatus(finalAuditResInfo.getCollegeCardAuditResStatus()));
            } else {
                finalAuditResInfo.setCollegeCardAuditResStatusName("未提交审核");
            }
            if (!Objects.isNull(finalAuditResInfo.getEducationAuditResStatus())) {
                finalAuditResInfo.setEducationAuditResStatusName(resultTranslate.translateAuditStatus(finalAuditResInfo.getEducationAuditResStatus()));
            } else {
                finalAuditResInfo.setEducationAuditResStatusName("未提交审核");
            }
            if (!Objects.isNull(finalAuditResInfo.getLibraryCardAuditResStatus())) {
                finalAuditResInfo.setLibraryCardAuditResStatusName(resultTranslate.translateAuditStatus(finalAuditResInfo.getLibraryCardAuditResStatus()));
            } else {
                finalAuditResInfo.setLibraryCardAuditResStatusName("未提交审核");
            }
            if (!Objects.isNull(finalAuditResInfo.getMemberCardAuditResStatus())) {
                finalAuditResInfo.setMemberCardAuditResStatusName(resultTranslate.translateAuditStatus(finalAuditResInfo.getMemberCardAuditResStatus()));
            } else {
                finalAuditResInfo.setMemberCardAuditResStatusName("未提交审核");
            }
            if (!Objects.isNull(finalAuditResInfo.getMinistryFinanceAuditResStatus())) {
                finalAuditResInfo.setMinistryFinanceAuditResStatusName(resultTranslate.translateAuditStatus(finalAuditResInfo.getMinistryFinanceAuditResStatus()));
            } else {
                finalAuditResInfo.setMinistryFinanceAuditResStatusName("未提交审核");
            }
            if (!Objects.isNull(finalAuditResInfo.getPartyBranchAuditResStatus())) {
                finalAuditResInfo.setPartyBranchAuditResStatusName(resultTranslate.translateAuditStatus(finalAuditResInfo.getPartyBranchAuditResStatus()));
            } else {
                finalAuditResInfo.setPartyBranchAuditResStatusName("未提交审核");
            }
            if (!Objects.isNull(finalAuditResInfo.getStuCardAuditResStatus())) {
                finalAuditResInfo.setStuCardAuditResStatusName(resultTranslate.translateAuditStatus(finalAuditResInfo.getStuCardAuditResStatus()));
            } else {
                finalAuditResInfo.setStuCardAuditResStatusName("未提交审核");
            }
            if (!Objects.isNull(finalAuditResInfo.getStatus())) {
                finalAuditResInfo.setAuditStatusName(resultTranslate.translateAuditStatus(finalAuditResInfo.getStatus()));
            } else {
                finalAuditResInfo.setAuditStatusName("未提交审核");
            }
        });
        return finalAuditResInfos;
    }

    @Override
    public List<FinalAuditResInfo> findAllFinalAuditResInfo() {
        return findByCondition(null);
    }

    @Override
    public Result updateFinalAuditRes(FinalAuditRes finalAuditRes) {
        if (!Objects.isNull(finalAuditRes.getId())) {
            finalAuditRes.setUpdateTime(new Date());
            if (finalAuditResMapper.updateByPrimaryKeySelective(finalAuditRes) == 1){
                return Result.success();
            }else {
                return Result.failure(ResultCode.SPECIFIED_QUESTIONED_USER_NOT_EXIST);
            }
        } else {
            finalAuditRes.setCreateTime(new Date());
            if (finalAuditResMapper.insertSelective(finalAuditRes) == 1) {
                return Result.success();
            } else {
                return Result.failure(ResultCode.SPECIFIED_QUESTIONED_USER_NOT_EXIST);
            }
        }
    }


}
