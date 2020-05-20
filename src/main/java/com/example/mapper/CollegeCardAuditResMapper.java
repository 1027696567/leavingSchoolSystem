package com.example.mapper;

import com.example.model.CollegeCardAuditRes;
import com.example.model.LibraryCardAuditRes;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CollegeCardAuditResMapper {
    int deleteByPrimaryKey(Long id);

    int insert(CollegeCardAuditRes record);

    int insertSelective(CollegeCardAuditRes record);

    CollegeCardAuditRes selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(CollegeCardAuditRes record);

    int updateByPrimaryKey(CollegeCardAuditRes record);

    CollegeCardAuditRes selectByCollegeCardId(Long id);
}