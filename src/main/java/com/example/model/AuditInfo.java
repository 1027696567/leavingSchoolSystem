package com.example.model;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * <p>
 * 
 * </p>
 *
 * @author cwyu
 * @since 2020-05-13
 */
@Data
public class AuditInfo implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 学生信息id
     */
    private Long stuInfoId;

    /**
     * 二级学院审核状态
     */
    private Integer secondCollegeStatus;

    /**
     * 组织部审核状态
     */
    private Integer organizationDeptStatus;

    /**
     * 团委审核状态
     */
    private Integer communistYouthLeagueStatus;

    /**
     * 图书馆审核状态
     */
    private Integer libraryStatus;

    /**
     * 教务处审核状态
     */
    private Integer academicAffairsStatus;

    /**
     * 财务处审核状态
     */
    private Integer financialDeptStatus;

    /**
     * 宿管审核状态
     */
    private Integer dormitoryStatus;

    /**
     * 国有资产管理科审核状态
     */
    private Integer sasacStatus;

    /**
     * 最终审核状态
     */
    private Integer status;

    /**
     * 创建时间
     */
    private LocalDate createTime;

    /**
     * 创建人
     */
    private String createUser;

    /**
     * 更新时间
     */
    private LocalDate updateTime;

    /**
     * 更新人
     */
    private String updateUser;

    /**
     * 是否可用
     */
    private Integer active;


}
