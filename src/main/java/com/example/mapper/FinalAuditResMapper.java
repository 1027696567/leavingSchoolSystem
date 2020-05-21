package com.example.mapper;

import com.example.model.FinalAuditRes;
import com.example.model.FinalAuditResInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FinalAuditResMapper {
    int deleteByPrimaryKey(Long id);

    int insert(FinalAuditRes record);

    int insertSelective(FinalAuditRes record);

    FinalAuditRes selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(FinalAuditRes record);

    int updateByPrimaryKey(FinalAuditRes record);

    List<FinalAuditResInfo> selectByCondition(String username);
}