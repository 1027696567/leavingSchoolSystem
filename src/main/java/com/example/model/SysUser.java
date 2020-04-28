package com.example.model;

import lombok.Data;

import java.io.Serializable;

/**
 * sys_user
 * @author
 */
@Data
public class SysUser implements Serializable {
    private Integer id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 真实姓名
     */
    private String realName;

    /**
     * 盐
     */
    private String salt;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 状态  0：禁用   1：正常
     */
    private Byte status;

    /**
     * 创建者ID
     */
    private Integer createUserId;

    /**
     * 创建时间
     */
    private String createTime;

    private static final long serialVersionUID = 1L;
}
