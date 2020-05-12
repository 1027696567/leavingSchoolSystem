package com.example.service;

import com.example.model.Result;
import com.example.model.StuCard;
import com.example.model.StuCardInfo;

import java.util.List;

public interface AuditService {
    List<StuCardInfo> findByUsername(String username);

    Result updateStuCardStatus(StuCard stuCard);

    List<StuCardInfo> findAllStuCard();

    List<StuCardInfo> findByCondition(Byte status,Long stuId,Long classId);
}
