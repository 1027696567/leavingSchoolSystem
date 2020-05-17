package com.example.model;

import java.io.Serializable;
import java.util.Date;

/**
 * library_card_audit_res
 * @author 
 */
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getStuInfoId() {
        return stuInfoId;
    }

    public void setStuInfoId(Long stuInfoId) {
        this.stuInfoId = stuInfoId;
    }

    public Long getLibraryCardId() {
        return libraryCardId;
    }

    public void setLibraryCardId(Long libraryCardId) {
        this.libraryCardId = libraryCardId;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }
}