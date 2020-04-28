package com.example.model;

import lombok.Data;

import java.io.Serializable;

/**
 * sys_user_role
 * @author
 */
@Data
public class SysUserRole implements Serializable {
    private Integer id;

    /**
     * 用户ID
     */
    private Integer userId;

    /**
     * 角色ID
     */
    private Integer roleId;

    private static final long serialVersionUID = 1L;
}
