package com.example.mapper;

import com.example.model.SysMenu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Set;

@Mapper
public interface SysMenuMapper {
    int deleteByPrimaryKey(Integer menuId);

    int insert(SysMenu record);

    int insertSelective(SysMenu record);

    SysMenu selectByPrimaryKey(Integer menuId);

    int updateByPrimaryKeySelective(SysMenu record);

    int updateByPrimaryKey(SysMenu record);

    List<SysMenu> selectByUserName(String username);

    List<SysMenu> selectByUserNameAndType(String username,Integer type);
}
