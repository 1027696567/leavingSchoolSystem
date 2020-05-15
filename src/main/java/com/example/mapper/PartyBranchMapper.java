package com.example.mapper;

import com.example.model.PartyBranch;
import com.example.model.PartyBranchInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PartyBranchMapper {

    int updateByPrimaryKeySelective(PartyBranch record);

    List<PartyBranchInfo> selectByUsername(String username);

    List<PartyBranchInfo> selectByCondition(Byte status,Long stuId,Long classId, Byte partyBranchAuditResStatus);
}
