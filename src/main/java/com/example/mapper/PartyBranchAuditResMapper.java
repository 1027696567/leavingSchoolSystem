package com.example.mapper;

import com.example.model.PartyBranchAuditRes;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PartyBranchAuditResMapper {
    int insertSelective(PartyBranchAuditRes partyBranchAuditRes);

    int updateByPrimaryKeySelective(PartyBranchAuditRes partyBranchAuditRes);

    PartyBranchAuditRes selectByPartyBranchId(Long partyBranchId);
}
