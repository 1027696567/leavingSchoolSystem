package com.example.mapper;

import com.example.model.StuCard;
import com.example.model.StuCardInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StuCardMapper {
    int deleteByPrimaryKey(Long id);

    int insert(StuCard record);

    int insertSelective(StuCard record);

    StuCard selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(StuCard record);

    int updateByPrimaryKey(StuCard record);

    List<StuCardInfo> selectByUsername(String username);

    List<StuCardInfo> selectByCondition(Byte status,Long stuId,Long classId);
}