package com.example.mapper;

import com.example.model.StuInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StuInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(StuInfo record);

    int insertSelective(StuInfo record);

    StuInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(StuInfo record);

    int updateByPrimaryKey(StuInfo record);
}