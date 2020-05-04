package com.example.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * information
 * @author
 */

@Data
public class Information implements Serializable {
    private Long id;

    /**
     * 咨询标题
     */
    private String title;

    /**
     * 咨询内容
     */
    private String content;

    /**
     * 封面图片
     */
    private String img;

    /**
     * 部门Id
     */
    private Long deptId;

    /**
     * 审核状态，0待审核，1审核通过，-1审核不通过
     */
    private Byte auditStatus;

    /**
     * 上下架状态，-1未上架，1已上架
     */
    private Byte status;

    /**
     * 审核结果Id
     */
    private Long auditResId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 创建用户名
     */
    private String createUser;

    /**
     * 更新用户名
     */
    private String updateUser;

    /**
     * 是否可用，1可用，-1不可用
     */
    private Byte active;

    private static final long serialVersionUID = 1L;

}
