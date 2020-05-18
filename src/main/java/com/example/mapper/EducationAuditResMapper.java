package com.example.mapper;

import com.example.model.EducationAuditRes;
import com.example.model.LibraryCardAuditRes;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EducationAuditResMapper {
    int deleteByPrimaryKey(Long id);

    int insert(EducationAuditRes record);

    int insertSelective(EducationAuditRes record);

    EducationAuditRes selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(EducationAuditRes record);

    int updateByPrimaryKey(EducationAuditRes record);

    EducationAuditRes selectByEducationId(Long id);
}