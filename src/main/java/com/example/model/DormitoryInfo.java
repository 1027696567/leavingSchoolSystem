package com.example.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class DormitoryInfo extends BaseModel implements Serializable {
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

    private String returnDateName;

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
     * 宿管审核信息部分
     * */
    private Long dormitoryAuditResId;

    private Byte dormitoryAuditResStatus;

    private String dormitoryAuditResContent;

    /**
     * 审核时间
     * */
    private Date createTime;
    /**
     * 审核人
     * */
    private String createUser;
}
