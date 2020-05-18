package com.example.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * library_card_audit_res
 * @author 
 */
@Data
public class LibraryCardAuditRes implements Serializable {
    private Long id;

    /**
     * 学生信息id
     */
    private Long stuInfoId;

    /**
     * 图书证id
     */
    private Long libraryCardId;

    /**
     * 审核状态
     */
    private Byte status;

    /**
     * 审核内容
     */
    private String content;

    /**
     * 审核时间
     */
    private Date createTime;

    /**
     * 审核人
     */
    private String createUser;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 更新人
     */
    private String updateUser;

    private static final long serialVersionUID = 1L;

}