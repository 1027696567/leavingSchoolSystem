package com.example.model;

import lombok.Data;

import java.io.Serializable;

/**
 * sys_role_menu
 * @author
 */
@Data
public class SysRoleMenu implements Serializable {
    private Integer id;

    /**
     * 角色ID
     */
    private Integer roleId;

    /**
     * 菜单ID
     */
    private Integer menuId;

    private static final long serialVersionUID = 1L;
}
