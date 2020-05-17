package com.example.mapper;

import com.example.model.AuditRes;
import com.example.model.MemberCardAuditRes;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberCardAuditResMapper {
    int deleteByPrimaryKey(Long id);

    int insert(MemberCardAuditRes record);

    int insertSelective(MemberCardAuditRes record);

    MemberCardAuditRes selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MemberCardAuditRes record);

    int updateByPrimaryKey(MemberCardAuditRes record);

    MemberCardAuditRes selectByMemberCardId(Long id);
}