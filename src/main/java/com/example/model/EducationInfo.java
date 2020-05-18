package com.example.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class EducationInfo extends BaseModel implements Serializable {
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
     * 教务处审核信息部分
     * */
    private Long educationAuditResId;

    private Byte educationAuditResStatus;

    private String educationAuditResContent;

    /**
     * 审核时间
     * */
    private Date createTime;
    /**
     * 审核人
     * */
    private String createUser;
}
