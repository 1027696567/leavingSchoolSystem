package com.example.service;

import com.example.model.*;

import java.util.List;

public interface DormitoryService {
    List<DormitoryInfo> findByUsername(String username);

    Result updateDormitoryStatus(Dormitory dormitory);

    List<DormitoryInfo> findByCondition(Byte status,Long stuId,Long classId, Byte dormitoryAuditResStatus);

    Result updateDormitoryAuditRes(DormitoryAuditRes dormitoryAuditRes);
}
