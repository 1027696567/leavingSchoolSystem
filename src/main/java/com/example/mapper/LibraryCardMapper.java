package com.example.mapper;

import com.example.model.LibraryCard;

public interface LibraryCardMapper {
    int deleteByPrimaryKey(Long id);

    int insert(LibraryCard record);

    int insertSelective(LibraryCard record);

    LibraryCard selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(LibraryCard record);

    int updateByPrimaryKey(LibraryCard record);
}