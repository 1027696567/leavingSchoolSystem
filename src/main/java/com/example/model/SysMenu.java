package com.example.model;

import lombok.Data;

import java.io.Serializable;

/**
 * sys_menu
 * @author
 */
@Data
public class SysMenu implements Serializable {
    private Integer menuId;

    /**
     * 父顶栏ID，若自身为顶栏则为0
     */
    private Integer navbarId;

    /**
     * 父菜单ID，一级菜单为0
     */
    private Integer parentId;

    /**
     * 菜单名称
     */
    private String name;

    /**
     * 菜单URL
     */
    private String url;

    /**
     * 授权(多个用逗号分隔，如：user:list,user:create)
     */
    private String perms;

    /**
     * 类型   0：目录   1：菜单   2：按钮
     */
    private Integer type;

    /**
     * 菜单图标
     */
    private String icon;

    /**
     * 排序
     */
    private Integer orderNum;

    private static final long serialVersionUID = 1L;
}
