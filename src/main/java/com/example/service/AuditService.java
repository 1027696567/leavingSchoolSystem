package com.example.service;

import com.example.model.StuCard;

public interface AuditService {
    StuCard findByUsername(String username);
}
