package com.example.service;

import com.example.model.FinalAuditRes;
import com.example.model.FinalAuditResInfo;
import com.example.model.Result;

import java.util.List;

public interface FinalAuditResService {
    List<FinalAuditResInfo> findByCondition(String username);

    List<FinalAuditResInfo> findAllFinalAuditResInfo();

    Result updateFinalAuditRes(FinalAuditRes finalAuditRes);
}
