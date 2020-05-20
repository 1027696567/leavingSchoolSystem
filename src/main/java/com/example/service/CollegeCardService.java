package com.example.service;

import com.example.model.*;

import java.util.List;

public interface CollegeCardService {
    List<CollegeCardInfo> findByUsername(String username);

    Result updateCollegeCardStatus(CollegeCard collegeCard);

    List<CollegeCardInfo> findByCondition(Byte status,Long stuId,Long classId, Byte collegeCardAuditResStatus);

    Result updateCollegeCardAuditRes(CollegeCardAuditRes collegeCardAuditRes);
}