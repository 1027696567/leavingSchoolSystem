package com.example.model;

import java.io.Serializable;
import java.util.Date;

/**
 * member_card
 * @author 
 */
public class MemberCard implements Serializable {
    /**
     * 团委 
     */
    private Long id;

    /**
     * 学生信息表id
     */
    private Long stuInfoId;

    /**
     * 发证日期
     */
    private Date issueDate;

    /**
     * 注销日期
     */
    private Date cancelDate;

    /**
     * 证件状态
     */
    private Byte status;

    /**
     * 是否可用
     */
    private Byte active;

    /**
     * 创建人
     */
    private String createUser;

    /**
     * 创建时间
     */
    private Date createTime;

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

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public Date getCancelDate() {
        return cancelDate;
    }

    public void setCancelDate(Date cancelDate) {
        this.cancelDate = cancelDate;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Byte getActive() {
        return active;
    }

    public void setActive(Byte active) {
        this.active = active;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}