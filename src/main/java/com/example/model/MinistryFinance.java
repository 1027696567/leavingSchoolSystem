package com.example.model;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * @author 
 * 
 */
@Data
public class MinistryFinance implements Serializable {
    /**
     * 财务部
     */
    private Long id;

    /**
     * 学生信息表id
     */
    private Long stuInfoId;

    /**
     * 缴费日期
     */
    private Date payDate;

    /**
     * 缴费金额(水电费)
     */
    private Long money;

    /**
     * 实收金额
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