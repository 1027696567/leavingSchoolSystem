package com.example.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * stu_card
 * @author 
 */
@Data
public class PartyBranch implements Serializable {
    private Long id;

    /**
     * 学生信息表id
     */
    private Long stuInfoId;

    /**
     * 移交日期
     */
    private Date transferDate;

    /**
     * 转送日期
     */
    private Date passDate;

    private Byte status;

    /**
     * 转送地点
     */
    private String place;

    /**
     * 是否可用
     */
    private Byte active;

    private String createUser;

    private Date createTime;



    private static final long serialVersionUID = 1L;

}