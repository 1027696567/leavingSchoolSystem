package com.example.mapper;

import com.example.model.Information;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface InformationMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Information record);

    int insertSelective(Information record);

    Information selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Information record);

    int updateByPrimaryKey(Information record);

    List<Information> selectAll();

    List<Information> selectByCondition(String title,byte status,byte auditStatus);
}
