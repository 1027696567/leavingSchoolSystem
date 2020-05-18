package com.example.mapper;

import com.example.model.Education;
import com.example.model.EducationInfo;
import com.example.model.LibraryCardInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EducationMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Education record);

    int insertSelective(Education record);

    Education selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Education record);

    int updateByPrimaryKey(Education record);

    List<EducationInfo> selectByUsername(String username);

    List<EducationInfo> selectByCondition(Byte status,Long stuId,Long classId, Byte educationAuditResStatus);
}