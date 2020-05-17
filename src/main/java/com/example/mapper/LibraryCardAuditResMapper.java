package com.example.mapper;

import com.example.model.LibraryCardAuditRes;

public interface LibraryCardAuditResMapper {
    int deleteByPrimaryKey(Long id);

    int insert(LibraryCardAuditRes record);

    int insertSelective(LibraryCardAuditRes record);

    LibraryCardAuditRes selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(LibraryCardAuditRes record);

    int updateByPrimaryKey(LibraryCardAuditRes record);
}