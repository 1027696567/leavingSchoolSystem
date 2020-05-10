package com.example.service;

import com.example.model.Information;
import com.example.model.Result;

public interface SystemService {

    Result addInformation(Information information);

    Result findAllInformation();

    Result findByCondition(String title,byte status,byte auditStatus);

    Result findById(Long id);

    Result auditInformation(Information information);
}
