package com.example.mapper;

import com.example.model.MemberCard;

public interface MemberCardMapper {
    int deleteByPrimaryKey(Long id);

    int insert(MemberCard record);

    int insertSelective(MemberCard record);

    MemberCard selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MemberCard record);

    int updateByPrimaryKey(MemberCard record);
}