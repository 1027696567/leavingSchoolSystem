package com.example.model;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author cwyu
 * @since 2020-05-13
 */
@Data
public class DeptAuditRes implements Serializable {

    private static final long serialVersionUID=1L;
    private Long id;

    /**
     * 学号
     */
    private Long stuInfoId;

    /**
     * 学生证号
     * */
    private Long stuCardId;

    /**
     * 审核部门id
     */
    private Long deptId;

    /**
     * 审核状态,0待审核，1，审核通过，-1审核不通过
     */
    private Byte status;

    /**
     * 审核结果
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


}
