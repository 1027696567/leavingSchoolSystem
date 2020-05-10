package com.example.mapper;

import com.example.model.StuCard;

public interface StuCardMapper {
    int deleteByPrimaryKey(Long id);

    int insert(StuCard record);

    int insertSelective(StuCard record);

    StuCard selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(StuCard record);

    int updateByPrimaryKey(StuCard record);
}