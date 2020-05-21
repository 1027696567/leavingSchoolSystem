package com.example.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
public class FinalAuditResInfo extends BaseModel implements Serializable {
    /**
     * 最终审核
     */
    private Long id;

    /**
     * 学生信息id
     */
    private Long stuInfoId;

    /**
     * 审核状态
     */
    private Byte status;

    /**
     * 审核内容
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

    private static final long serialVersionUID = 1L;

    private Byte stuCardAuditResStatus;

    private String stuCardAuditResStatusName;

    private Byte collegeCardAuditResStatus;

    private String collegeCardAuditResStatusName;

    private Byte dormitoryAuditResStatus;

    private String dormitoryAuditResStatusName;

    private Byte educationAuditResStatus;

    private String educationAuditResStatusName;

    private Byte libraryCardAuditResStatus;

    private String libraryCardAuditResStatusName;

    private Byte memberCardAuditResStatus;

    private String memberCardAuditResStatusName;

    private Byte ministryFinanceAuditResStatus;

    private String ministryFinanceAuditResStatusName;

    private Byte partyBranchAuditResStatus;

    private String partyBranchAuditResStatusName;

    private String username;

    private String name;

    private Long stuId;

    private Long finalAuditResId;
}
