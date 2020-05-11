package com.example.model;

import lombok.Data;

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
     * 补发日期
     */
    private Date reissueDate;

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

    private Long identityId;

    private Long stuId;

    private Byte sex;

    private Byte eduSys;

    private Date admissionDate;

    private String deptName;

    private String professionName;

    private static final long serialVersionUID = 1L;
}
