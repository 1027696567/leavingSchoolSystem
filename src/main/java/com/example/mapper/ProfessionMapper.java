package com.example.mapper;

import com.example.model.Profession;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProfessionMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Profession record);

    int insertSelective(Profession record);

    Profession selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Profession record);

    int updateByPrimaryKey(Profession record);
}