package com.example.mapper;

import com.example.model.DormitoryAuditRes;
import com.example.model.EducationAuditRes;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DormitoryAuditResMapper {
    int deleteByPrimaryKey(Long id);

    int insert(DormitoryAuditRes record);

    int insertSelective(DormitoryAuditRes record);

    DormitoryAuditRes selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(DormitoryAuditRes record);

    int updateByPrimaryKey(DormitoryAuditRes record);

    DormitoryAuditRes selectByDormitoryId(Long id);
}