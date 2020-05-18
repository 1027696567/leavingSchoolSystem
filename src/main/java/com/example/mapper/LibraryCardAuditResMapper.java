package com.example.mapper;

import com.example.model.LibraryCardAuditRes;
import com.example.model.MemberCardAuditRes;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LibraryCardAuditResMapper {
    int deleteByPrimaryKey(Long id);

    int insert(LibraryCardAuditRes record);

    int insertSelective(LibraryCardAuditRes record);

    LibraryCardAuditRes selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(LibraryCardAuditRes record);

    int updateByPrimaryKey(LibraryCardAuditRes record);

    LibraryCardAuditRes selectByLibraryCardId(Long id);
}