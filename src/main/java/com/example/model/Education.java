package com.example.model;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * @author 
 * 
 */
@Data
public class Education implements Serializable {
    /**
     * 教务部
     */
    private Long id;

    /**
     * 学生信息表id
     */
    private Long stuInfoId;

    /**
     * 教材缴费日期
     */
    private Date payDate;

    /**
     * 教材金额
     */
    private Long money;

    /**
     * 已缴金额
     */
    private Long receiveMoney;

    /**
     * 缴费状态
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
}