package com.example.service.impl;

import com.example.mapper.*;
import com.example.model.*;
import com.example.service.MemberCardService;
import com.example.service.ResultTranslate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;
@Service
public class MemberCardServiceImpl implements MemberCardService {

    @Autowired
    private MemberCardMapper memberCardMapper;
    @Autowired
    private ResultTranslate resultTranslate;
    @Autowired
    private DepartmentMapper departmentMapper;
    @Autowired
    private MemberCardAuditResMapper memberCardAuditResMapper;
    @Override
    public List<MemberCardInfo> findByUsername(String username) {
        List<MemberCardInfo> memberCardInfos = memberCardMapper.selectByUsername(username);
        if (memberCardInfos.size()>0){
            memberCardInfos.forEach(memberCardInfo -> {
                memberCardInfo.setCancelStatus(resultTranslate.translateCancelStatus(memberCardInfo.getStatus()));
                memberCardInfo.setTranslateIssueDate(DateFormat.getDateInstance().format(memberCardInfo.getIssueDate()));
                //stuCardInfo.setTranslateReissueDate(DateFormat.getDateInstance().format(stuCardInfo.getReissueDate()));
                if (!Objects.isNull(memberCardInfo.getMemberCardAuditResStatus())) {
                    memberCardInfo.setAuditStatusName(resultTranslate.translateAuditStatus(memberCardInfo.getMemberCardAuditResStatus()));
                }
            });

            return memberCardInfos;
        } else {
            return null;
        }
    }

    @Override
    public Result updateMemberCardStatus(MemberCard memberCard) {
        memberCard.setCancelDate(new Date());
        if (memberCardMapper.updateByPrimaryKeySelective(memberCard) == 1){
            if (!Objects.isNull(memberCard.getCreateUser())&&Objects.isNull(memberCardAuditResMapper.selectByMemberCardId(memberCard.getId()))) {
                MemberCardAuditRes memberCardAuditRes = new MemberCardAuditRes();
                memberCardAuditRes.setStuInfoId(memberCard.getStuInfoId());
                memberCardAuditRes.setMemberCardId(memberCard.getId());
                memberCardAuditRes.setStatus((byte) 0);
                memberCardAuditResMapper.insertSelective(memberCardAuditRes);
            }
            return Result.success();
        } else {
            return Result.failure(ResultCode.SPECIFIED_QUESTIONED_USER_NOT_EXIST);
        }
    }

    @Override
    public List<MemberCardInfo> findByCondition(Byte status, Long stuId, Long classId, Byte memberCardAuditResStatus) {
        List<MemberCardInfo> memberCardInfos = memberCardMapper.selectByCondition(status,stuId,classId,memberCardAuditResStatus);
        memberCardInfos.forEach(memberCardInfo -> {
            memberCardInfo.setCancelStatus(resultTranslate.translateCancelStatus(memberCardInfo.getStatus()));
            memberCardInfo.setTranslateIssueDate(DateFormat.getDateInstance().format(memberCardInfo.getIssueDate()));
            //stuCardInfo.setTranslateReissueDate(DateFormat.getDateInstance().format(stuCardInfo.getReissueDate()));
            if (!Objects.isNull(memberCardInfo.getMemberCardAuditResStatus())) {
                memberCardInfo.setAuditStatusName(resultTranslate.translateAuditStatus(memberCardInfo.getMemberCardAuditResStatus()));
            }
        });
        return memberCardInfos;
    }

    @Override
    public Result updateMemberCardAuditRes(MemberCardAuditRes memberCardAuditRes) {
        memberCardAuditRes.setCreateTime(new Date());
        if (memberCardAuditResMapper.updateByPrimaryKeySelective(memberCardAuditRes) == 1) {
            return Result.success();
        } else {
            memberCardAuditRes.setCreateTime(new Date());
            memberCardAuditResMapper.insertSelective(memberCardAuditRes);
            return Result.success();
        }
    }
}
