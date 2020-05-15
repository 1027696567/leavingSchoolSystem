package com.example.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class PartyBranchInfo extends BaseModel implements Serializable {
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

    private String name;

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
     * 组织部审核信息部分
     * */
    private Long partyBranchAuditResId;

    private Byte partyBranchAuditResStatus;

    private String partyBranchAuditResContent;

    /**
     * 审核时间
     * */
    private Date createTime;
    /**
     * 审核人
     * */
    private String createUser;

    private static final long serialVersionUID = 1L;
}
