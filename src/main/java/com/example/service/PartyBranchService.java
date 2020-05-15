package com.example.service;

import com.example.model.*;

import java.util.List;

public interface PartyBranchService {
    List<PartyBranchInfo> findByUsername(String username);

    Result updatePartyBranchStatus(PartyBranch partyBranch);

    List<PartyBranchInfo> findByCondition(Byte status, Long stuId, Long classId, Byte partyBranchResStatus);

    Result updatePartyBranchAuditRes(PartyBranchAuditRes partyBranchAuditRes);
}
