package com.example.service;

import com.example.model.AuditRes;
import com.example.model.Information;
import com.example.model.Result;

public interface SystemService {

    Result addInformation(Information information);

    Result findAllInformation();

    Result findByCondition(String title,byte status,byte auditStatus);

    Result findById(Long id);

    Result auditInformation(AuditRes auditRes);

    Result updateInformation(Information information);

    Result updateInformationStatus(Information information);

    AuditRes findAuditResByInformationId(Long id);
}
