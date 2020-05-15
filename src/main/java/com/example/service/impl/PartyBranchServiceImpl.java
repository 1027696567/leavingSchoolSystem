package com.example.service.impl;

import com.example.mapper.*;
import com.example.model.*;
import com.example.service.ResultTranslate;
import com.example.service.PartyBranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Objects;
@Service
public class PartyBranchServiceImpl implements PartyBranchService {

    @Autowired
    private PartyBranchMapper partyBranchMapper;
    @Autowired
    private ResultTranslate resultTranslate;
    @Autowired
    private DepartmentMapper departmentMapper;
    @Autowired
    private PartyBranchAuditResMapper partyBranchAuditResMapper;

    @Override
    public List<PartyBranchInfo> findByUsername(String username) {
        List<PartyBranchInfo> partyBranchInfos = partyBranchMapper.selectByUsername(username);
        if (partyBranchInfos.size()>0){
            partyBranchInfos.forEach(partyBranchInfo -> {
                partyBranchInfo.setStatusName(resultTranslate.translatePassStatus(partyBranchInfo.getStatus()));
                if (!Objects.isNull(partyBranchInfo.getPartyBranchAuditResStatus())) {
                    partyBranchInfo.setAuditStatusName(resultTranslate.translateAuditStatus(partyBranchInfo.getPartyBranchAuditResStatus()));
                }
            });

            return partyBranchInfos;
        } else {
            return null;
        }
    }

    @Override
    public Result updatePartyBranchStatus(PartyBranch partyBranch) {
        if (partyBranchMapper.updateByPrimaryKeySelective(partyBranch) == 1){
            if (!Objects.isNull(partyBranch.getCreateUser())&&Objects.isNull(partyBranchAuditResMapper.selectByPartyBranchId(partyBranch.getId()))) {
                PartyBranchAuditRes partyBranchAuditRes = new PartyBranchAuditRes();
                partyBranchAuditRes.setPartyBranchId(partyBranch.getId());
                partyBranchAuditRes.setStuInfoId(partyBranch.getStuInfoId());
                partyBranchAuditRes.setStatus((byte) 0);
                partyBranchAuditResMapper.insertSelective(partyBranchAuditRes);
            }
            return Result.success();
        } else {
            return Result.failure(ResultCode.SPECIFIED_QUESTIONED_USER_NOT_EXIST);
        }
    }

    @Override
    public List<PartyBranchInfo> findByCondition(Byte status, Long stuId, Long classId, Byte partyBranchAuditResStatus) {
        List<PartyBranchInfo> partyBranchInfos = partyBranchMapper.selectByCondition(status,stuId,classId,partyBranchAuditResStatus);
        partyBranchInfos.forEach(partyBranchInfo -> {
            partyBranchInfo.setStatusName(resultTranslate.translatePassStatus(partyBranchInfo.getStatus()));
            if (!Objects.isNull(partyBranchInfo.getPartyBranchAuditResStatus())) {
                partyBranchInfo.setAuditStatusName(resultTranslate.translateAuditStatus(partyBranchInfo.getPartyBranchAuditResStatus()));
            }
        });
        return partyBranchInfos;
    }

    @Override
    public Result updatePartyBranchAuditRes(PartyBranchAuditRes partyBranchAuditRes) {
        partyBranchAuditRes.setCreateTime(new Date());
        if (partyBranchAuditResMapper.updateByPrimaryKeySelective(partyBranchAuditRes) == 1) {
            return Result.success();
        } else {
            partyBranchAuditRes.setCreateTime(new Date());
            partyBranchAuditResMapper.insertSelective(partyBranchAuditRes);
            return Result.success();
        }
    }
}
