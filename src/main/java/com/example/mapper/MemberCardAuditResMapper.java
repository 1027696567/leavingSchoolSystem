package com.example.mapper;

import com.example.model.MemberCardAuditRes;

public interface MemberCardAuditResMapper {
    int deleteByPrimaryKey(Long id);

    int insert(MemberCardAuditRes record);

    int insertSelective(MemberCardAuditRes record);

    MemberCardAuditRes selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MemberCardAuditRes record);

    int updateByPrimaryKey(MemberCardAuditRes record);
}