package com.example.service.impl;

import com.example.mapper.StuCardMapper;
import com.example.model.StuCard;
import com.example.model.StuCardInfo;
import com.example.service.AuditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuditServiceImpl implements AuditService {

    @Autowired
    private StuCardMapper stuCardMapper;
    @Override
    public StuCard findByUsername(String username) {
        return stuCardMapper.selectByUsername(username);
    }
}
