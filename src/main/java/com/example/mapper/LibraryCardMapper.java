package com.example.mapper;

import com.example.model.LibraryCard;
import com.example.model.LibraryCardInfo;
import com.example.model.MemberCardInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface LibraryCardMapper {
    int deleteByPrimaryKey(Long id);

    int insert(LibraryCard record);

    int insertSelective(LibraryCard record);

    LibraryCard selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(LibraryCard record);

    int updateByPrimaryKey(LibraryCard record);

    List<LibraryCardInfo> selectByUsername(String username);

    List<LibraryCardInfo> selectByCondition(Byte status,Long stuId,Long classId, Byte libraryCardAuditResStatus);
}