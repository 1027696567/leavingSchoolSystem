package com.example.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
public class CollegeCardInfo extends BaseModel implements Serializable {
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

    private String cancelDateName;

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
     * 图书馆审核信息部分
     * */
    private Long CollegeCardAuditResId;

    private Byte CollegeCardAuditResStatus;

    private String CollegeCardAuditResContent;

    /**
     * 审核时间
     * */
    private Date createTime;
    /**
     * 审核人
     * */
    private String createUser;
}
