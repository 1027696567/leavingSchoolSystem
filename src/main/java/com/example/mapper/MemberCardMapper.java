package com.example.mapper;

import com.example.model.MemberCard;
import com.example.model.MemberCardInfo;
import com.example.model.StuCardInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface MemberCardMapper {
    int deleteByPrimaryKey(Long id);

    int insert(MemberCard record);

    int insertSelective(MemberCard record);

    MemberCard selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MemberCard record);

    int updateByPrimaryKey(MemberCard record);

    List<MemberCardInfo> selectByUsername(String username);

    List<MemberCardInfo> selectByCondition(Byte status,Long stuId,Long classId, Byte memberCardAuditResStatus);
}