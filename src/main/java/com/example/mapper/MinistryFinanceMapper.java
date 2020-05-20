package com.example.mapper;

import com.example.model.EducationInfo;
import com.example.model.MinistryFinance;
import com.example.model.MinistryFinanceInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MinistryFinanceMapper {
    int deleteByPrimaryKey(Long id);

    int insert(MinistryFinance record);

    int insertSelective(MinistryFinance record);

    MinistryFinance selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MinistryFinance record);

    int updateByPrimaryKey(MinistryFinance record);

    List<MinistryFinanceInfo> selectByUsername(String username);

    List<MinistryFinanceInfo> selectByCondition(Byte status,Long stuId,Long classId, Byte ministryFinanceAuditResStatus);
}