package com.example.mapper;

import com.example.model.Department;
import com.example.model.DeptAuditRes;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author cwyu
 * @since 2020-05-13
 */
@Mapper
public interface DeptAuditResMapper {
    int insertSelective(DeptAuditRes deptAuditRes);

    int updateByPrimaryKeySelective(DeptAuditRes deptAuditRes);

    DeptAuditRes selectByStuCardId(Long stuCardId);

}
