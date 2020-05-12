package com.example.service.impl;

import com.example.mapper.StuCardMapper;
import com.example.model.Result;
import com.example.model.ResultCode;
import com.example.model.StuCard;
import com.example.model.StuCardInfo;
import com.example.service.AuditService;
import com.example.service.ResultTranslate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuditServiceImpl implements AuditService {

    @Autowired
    private StuCardMapper stuCardMapper;
    @Autowired
    private ResultTranslate resultTranslate;
    @Override
    public List<StuCardInfo> findByUsername(String username) {
        List<StuCardInfo> stuCardInfos = stuCardMapper.selectByUsername(username);
        if (stuCardInfos.size()>0){
            stuCardInfos.forEach(stuCardInfo -> stuCardInfo.setCancelStatus(resultTranslate.translateCancelStatus(stuCardInfo.getStatus())));
            return stuCardInfos;
        } else {
            return null;
        }

    }

    @Override
    public Result updateStuCardStatus(StuCard stuCard) {
        if (stuCardMapper.updateByPrimaryKeySelective(stuCard) == 1){
            return Result.success();
        } else {
            return Result.failure(ResultCode.SPECIFIED_QUESTIONED_USER_NOT_EXIST);
        }
    }

    @Override
    public List<StuCardInfo> findAllStuCard() {
        List<StuCardInfo> stuCardInfos = stuCardMapper.selectByCondition(null,null,null);
        stuCardInfos.forEach(stuCardInfo -> stuCardInfo.setCancelStatus(resultTranslate.translateCancelStatus(stuCardInfo.getStatus())));
        return stuCardInfos;
    }

    @Override
    public List<StuCardInfo> findByCondition(Byte status,Long stuId,Long classId) {
        List<StuCardInfo> stuCardInfos = stuCardMapper.selectByCondition(status,stuId,classId);
        stuCardInfos.forEach(stuCardInfo -> stuCardInfo.setCancelStatus(resultTranslate.translateCancelStatus(stuCardInfo.getStatus())));
        return stuCardInfos;
    }


}
