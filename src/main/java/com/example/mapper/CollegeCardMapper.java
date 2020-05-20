package com.example.mapper;

import com.example.model.CollegeCard;
import com.example.model.CollegeCardInfo;
import com.example.model.LibraryCardInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CollegeCardMapper {
    int deleteByPrimaryKey(Long id);

    int insert(CollegeCard record);

    int insertSelective(CollegeCard record);

    CollegeCard selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(CollegeCard record);

    int updateByPrimaryKey(CollegeCard record);

    List<CollegeCardInfo> selectByUsername(String username);

    List<CollegeCardInfo> selectByCondition(Byte status,Long stuId,Long classId, Byte collegeCardAuditResStatus);
}