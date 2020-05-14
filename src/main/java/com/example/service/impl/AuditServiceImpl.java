package com.example.service.impl;

import com.example.mapper.DepartmentMapper;
import com.example.mapper.DeptAuditResMapper;
import com.example.mapper.StuCardMapper;
import com.example.model.*;
import com.example.service.AuditService;
import com.example.service.ResultTranslate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
public class AuditServiceImpl implements AuditService {

    @Autowired
    private StuCardMapper stuCardMapper;
    @Autowired
    private ResultTranslate resultTranslate;
    @Autowired
    private DepartmentMapper departmentMapper;
    @Autowired
    private DeptAuditResMapper deptAuditResMapper;
    @Override
    public List<StuCardInfo> findByUsername(String username) {
        List<StuCardInfo> stuCardInfos = stuCardMapper.selectByUsername(username);
        if (stuCardInfos.size()>0){
            stuCardInfos.forEach(stuCardInfo -> {
                stuCardInfo.setCancelStatus(resultTranslate.translateCancelStatus(stuCardInfo.getStatus()));
                if (!Objects.isNull(stuCardInfo.getDeptAuditResStatus())) {
                    stuCardInfo.setAuditStatusName(resultTranslate.translateAuditStatus(stuCardInfo.getDeptAuditResStatus()));
                }
            });

            return stuCardInfos;
        } else {
            return null;
        }

    }

    @Override
    public Result updateStuCardStatus(StuCard stuCard) {
        if (stuCardMapper.updateByPrimaryKeySelective(stuCard) == 1){
            if (!Objects.isNull(stuCard.getCreateUser())&&Objects.isNull(deptAuditResMapper.selectByStuCardId(stuCard.getId()))) {
                DeptAuditRes deptAuditRes = new DeptAuditRes();
                deptAuditRes.setStuInfoId(stuCard.getStuInfoId());
                deptAuditRes.setStuCardId(stuCard.getId());
                deptAuditRes.setStatus((byte) 0);
                deptAuditResMapper.insertSelective(deptAuditRes);
            }
            return Result.success();
        } else {
            return Result.failure(ResultCode.SPECIFIED_QUESTIONED_USER_NOT_EXIST);
        }
    }

    @Override
    public List<StuCardInfo> findByCondition(Byte status,Long stuId,Long classId, Byte deptAuditResStatus) {
        List<StuCardInfo> stuCardInfos = stuCardMapper.selectByCondition(status,stuId,classId,deptAuditResStatus);
        stuCardInfos.forEach(stuCardInfo -> {
            stuCardInfo.setCancelStatus(resultTranslate.translateCancelStatus(stuCardInfo.getStatus()));
            if (!Objects.isNull(stuCardInfo.getDeptAuditResStatus())) {
                stuCardInfo.setAuditStatusName(resultTranslate.translateAuditStatus(stuCardInfo.getDeptAuditResStatus()));
            }
        });
        return stuCardInfos;
    }

    @Override
    public Result updateDeptAuditRes(DeptAuditRes deptAuditRes) {
        deptAuditRes.setCreateTime(new Date());
        if (deptAuditResMapper.updateByPrimaryKeySelective(deptAuditRes) == 1) {
            return Result.success();
        } else {
            deptAuditRes.setCreateTime(new Date());
            deptAuditResMapper.insertSelective(deptAuditRes);
            return Result.success();
        }
    }


}
