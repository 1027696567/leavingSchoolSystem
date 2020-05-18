package com.example.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class LibraryCardInfo extends BaseModel implements Serializable {
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
     * 转换发证日期
     * */
    private String translateIssueDate;

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
    private Long libraryCardAuditResId;

    private Byte libraryCardAuditResStatus;

    private String libraryCardAuditResContent;

    /**
     * 审核时间
     * */
    private Date createTime;
    /**
     * 审核人
     * */
    private String createUser;

}
