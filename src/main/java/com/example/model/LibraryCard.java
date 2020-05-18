package com.example.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * library_card
 * @author 
 */
@Data
public class LibraryCard implements Serializable {
    /**
     * 图书馆
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

}