package com.example.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Data
public class StuCardInfo extends BaseModel implements Serializable {
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
     * 补发日期
     */
    private Date reissueDate;

    private String translateReissueDate;

    private Byte status;

    /**
     * 注销日期
     */
    private Date cancelDate;

    /**
     * 是否可用
     */
    private Byte active;

    private String name;

    @JsonSerialize(using = ToStringSerializer.class)
    private Long identityId;

    private Long stuId;

    private Byte sex;

    private Byte eduSys;

    private Date admissionDate;

    private String deptName;

    private String professionName;

    private Long classId;

    private Long deptAuditResId;

    private Byte deptAuditResStatus;

    private String deptAuditResContent;

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
