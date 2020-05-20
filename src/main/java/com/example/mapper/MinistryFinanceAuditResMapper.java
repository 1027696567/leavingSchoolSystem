package com.example.mapper;

import com.example.model.EducationAuditRes;
import com.example.model.MinistryFinanceAuditRes;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MinistryFinanceAuditResMapper {
    int deleteByPrimaryKey(Long id);

    int insert(MinistryFinanceAuditRes record);

    int insertSelective(MinistryFinanceAuditRes record);

    MinistryFinanceAuditRes selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MinistryFinanceAuditRes record);

    int updateByPrimaryKey(MinistryFinanceAuditRes record);

    MinistryFinanceAuditRes selectByMinistryFinanceId(Long id);
}