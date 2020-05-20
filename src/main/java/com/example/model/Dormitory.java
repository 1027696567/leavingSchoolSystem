package com.example.model;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * @author 
 * 
 */
@Data
public class Dormitory implements Serializable {
    /**
     * 宿管部
     */
    private Long id;

    /**
     * 学生信息表id
     */
    private Long stuInfoId;

    /**
     * 还钥匙日期
     */
    private Date returnDate;

    /**
     * 寝室号
     */
    private Long dormNumber;

    /**
     * 钥匙状态
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