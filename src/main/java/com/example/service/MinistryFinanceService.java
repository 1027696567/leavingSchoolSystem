package com.example.service;

import com.example.model.*;
import org.springframework.stereotype.Service;

import java.util.List;

public interface MinistryFinanceService {
    List<MinistryFinanceInfo> findByUsername(String username);

    Result updateMinistryFinanceStatus(MinistryFinance ministryFinance);

    List<MinistryFinanceInfo> findByCondition(Byte status,Long stuId,Long classId, Byte ministryFinanceAuditResStatus);

    Result updateMinistryFinanceAuditRes(MinistryFinanceAuditRes ministryFinanceAuditRes);
}

