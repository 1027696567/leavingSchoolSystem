package com.example.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class MinistryFinanceInfo extends BaseModel implements Serializable {
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

    private String name;

    private static final long serialVersionUID = 1L;

    /**
     * 学生基本信息部分
     * */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long identityId;

    private Long stuId;

    private Byte sex;

    private Byte eduSys;

    private Date admissionDate;

    private String deptName;

    private String professionName;

    private Long classId;

    /**
     * 财务处审核信息部分
     * */
    private Long ministryFinanceAuditResId;

    private Byte ministryFinanceAuditResStatus;

    private String ministryFinanceAuditResContent;

    /**
     * 审核时间
     * */
    private Date createTime;
    /**
     * 审核人
     * */
    private String createUser;
}
