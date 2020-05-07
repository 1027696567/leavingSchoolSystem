package com.example.model;

import lombok.Data;

import java.io.Serializable;

/**
 * sys_role
 * @author
 */
@Data
public class SysRole implements Serializable {
    private Integer roleId;

    /**
     * 角色名称
     */
    private String roleName;

    /**
     * 备注
     */
    private String remark;

    /**
     * 创建者ID
     */
    private Integer createUserId;

    /**
     * 创建时间
     */
    private String createTime;

    private Long deptId;

    private static final long serialVersionUID = 1L;
}
