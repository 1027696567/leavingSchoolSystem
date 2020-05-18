package com.example.service;

import com.example.model.*;

import java.util.List;

public interface LibraryCardService {
    List<LibraryCardInfo> findByUsername(String username);

    Result updateLibraryCardStatus(LibraryCard libraryCard);

    List<LibraryCardInfo> findByCondition(Byte status,Long stuId,Long classId, Byte libraryCardAuditResStatus);

    Result updateLibraryCardAuditRes(LibraryCardAuditRes libraryCardAuditRes);
}
