package com.example.service.impl;

import com.example.mapper.*;
import com.example.model.*;
import com.example.service.CollegeCardService;
import com.example.service.ResultTranslate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;
@Service
public class CollegeCardServiceImpl implements CollegeCardService {
    @Autowired
    private CollegeCardMapper collegeCardMapper;
    @Autowired
    private ResultTranslate resultTranslate;
    @Autowired
    private DepartmentMapper departmentMapper;
    @Autowired
    private CollegeCardAuditResMapper collegeCardAuditResMapper;
    @Override
    public List<CollegeCardInfo> findByUsername(String username) {
        List<CollegeCardInfo> collegeCardInfos = collegeCardMapper.selectByUsername(username);
        if (collegeCardInfos.size()>0){
            collegeCardInfos.forEach(collegeCardInfo -> {
                collegeCardInfo.setCancelStatus(resultTranslate.translateCancelStatus(collegeCardInfo.getStatus()));
                if (!Objects.isNull(collegeCardInfo.getCancelDate())) {
                    collegeCardInfo.setCancelDateName(DateFormat.getDateInstance().format(collegeCardInfo.getCancelDate()));
                }
                if (!Objects.isNull(collegeCardInfo.getCollegeCardAuditResStatus())) {
                    collegeCardInfo.setAuditStatusName(resultTranslate.translateAuditStatus(collegeCardInfo.getCollegeCardAuditResStatus()));
                }
            });

            return collegeCardInfos;
        } else {
            return null;
        }
    }

    @Override
    public Result updateCollegeCardStatus(CollegeCard collegeCard) {
        collegeCard.setCancelDate(new Date());
        if (collegeCardMapper.updateByPrimaryKeySelective(collegeCard) == 1){
            if (!Objects.isNull(collegeCard.getCreateUser())&&Objects.isNull(collegeCardAuditResMapper.selectByCollegeCardId(collegeCard.getId()))) {
                CollegeCardAuditRes collegeCardAuditRes = new CollegeCardAuditRes();
                collegeCardAuditRes.setStuInfoId(collegeCard.getStuInfoId());
                collegeCardAuditRes.setCollegeCardId(collegeCard.getId());
                collegeCardAuditRes.setStatus((byte) 0);
                collegeCardAuditResMapper.insertSelective(collegeCardAuditRes);
            }
            return Result.success();
        } else {
            return Result.failure(ResultCode.SPECIFIED_QUESTIONED_USER_NOT_EXIST);
        }
    }

    @Override
    public List<CollegeCardInfo> findByCondition(Byte status, Long stuId, Long classId, Byte collegeCardAuditResStatus) {
        List<CollegeCardInfo> collegeCardInfos = collegeCardMapper.selectByCondition(status,stuId,classId,collegeCardAuditResStatus);
        collegeCardInfos.forEach(collegeCardInfo -> {
            collegeCardInfo.setCancelStatus(resultTranslate.translateCancelStatus(collegeCardInfo.getStatus()));
            if (!Objects.isNull(collegeCardInfo.getCancelDate())) {
                collegeCardInfo.setCancelDateName(DateFormat.getDateInstance().format(collegeCardInfo.getCancelDate()));
            }
            if (!Objects.isNull(collegeCardInfo.getCollegeCardAuditResStatus())) {
                collegeCardInfo.setAuditStatusName(resultTranslate.translateAuditStatus(collegeCardInfo.getCollegeCardAuditResStatus()));
            }
        });
        return collegeCardInfos;
    }

    @Override
    public Result updateCollegeCardAuditRes(CollegeCardAuditRes collegeCardAuditRes) {
        collegeCardAuditRes.setCreateTime(new Date());
        if (collegeCardAuditResMapper.updateByPrimaryKeySelective(collegeCardAuditRes) == 1) {
            return Result.success();
        } else {
            collegeCardAuditRes.setCreateTime(new Date());
            collegeCardAuditResMapper.insertSelective(collegeCardAuditRes);
            return Result.success();
        }
    }
}
