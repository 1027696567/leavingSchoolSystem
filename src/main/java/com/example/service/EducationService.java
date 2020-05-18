package com.example.service;

import com.example.model.*;

import java.util.List;

public interface EducationService {
    List<EducationInfo> findByUsername(String username);

    Result updateEducationStatus(Education education);

    List<EducationInfo> findByCondition(Byte status,Long stuId,Long classId, Byte educationAuditResStatus);

    Result updateEducationAuditRes(EducationAuditRes educationAuditRes);
}
