package com.example.model;

import java.io.Serializable;
import java.util.Date;

/**
 * stu_card
 * @author 
 */
public class StuCard implements Serializable {
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
     * 补发日期
     */
    private Date reissueDate;

    private Byte status;

    /**
     * 注销日期
     */
    private Date cancelDate;

    /**
     * 是否可用
     */
    private Byte active;

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

    public Date getReissueDate() {
        return reissueDate;
    }

    public void setReissueDate(Date reissueDate) {
        this.reissueDate = reissueDate;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Date getCancelDate() {
        return cancelDate;
    }

    public void setCancelDate(Date cancelDate) {
        this.cancelDate = cancelDate;
    }

    public Byte getActive() {
        return active;
    }

    public void setActive(Byte active) {
        this.active = active;
    }
}