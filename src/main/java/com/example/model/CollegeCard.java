package com.example.model;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * @author 
 * 
 */
@Data
public class CollegeCard implements Serializable {
    /**
     * 国有资产管理部
     */
    private Long id;

    /**
     * 学生信息表id
     */
    private Long stuInfoId;

    /**
     * 注销日期
     */
    private Date cancelDate;

    /**
     * 一卡通余额
     */
    private Long money;

    /**
     * 一卡通状态
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