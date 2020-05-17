package com.example.service;

import com.example.model.*;

import java.util.List;

public interface MemberCardService {
    List<MemberCardInfo> findByUsername(String username);

    Result updateMemberCardStatus(MemberCard memberCard);

    List<MemberCardInfo> findByCondition(Byte status,Long stuId,Long classId, Byte memberCardAuditResStatus);

    Result updateMemberCardAuditRes(MemberCardAuditRes memberCardAuditRes);
}
