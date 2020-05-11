package com.example.mapper;

import com.example.model.AuditRes;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AuditResMapper {
    int deleteByPrimaryKey(Long id);

    int insert(AuditRes record);

    int insertSelective(AuditRes record);

    AuditRes selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AuditRes record);

    int updateByPrimaryKey(AuditRes record);

    AuditRes selectByInformationId(Long id);
}