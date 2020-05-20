package com.example.mapper;

import com.example.model.Dormitory;
import com.example.model.DormitoryInfo;
import com.example.model.EducationInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DormitoryMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Dormitory record);

    int insertSelective(Dormitory record);

    Dormitory selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Dormitory record);

    int updateByPrimaryKey(Dormitory record);

    List<DormitoryInfo> selectByUsername(String username);

    List<DormitoryInfo> selectByCondition(Byte status,Long stuId,Long classId, Byte dormitoryAuditResStatus);
}