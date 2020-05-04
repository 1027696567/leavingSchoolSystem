package com.example.mapper;

import com.example.model.Information;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface InformationMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Information record);

    int insertSelective(Information record);

    Information selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Information record);

    int updateByPrimaryKey(Information record);
}
