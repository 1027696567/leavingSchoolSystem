package com.example.mapper;

import com.example.model.StuCard;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StuCardMapper {
    int deleteByPrimaryKey(Long id);

    int insert(StuCard record);

    int insertSelective(StuCard record);

    StuCard selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(StuCard record);

    int updateByPrimaryKey(StuCard record);
}