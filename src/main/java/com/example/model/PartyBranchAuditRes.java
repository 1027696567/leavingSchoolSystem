package com.example.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author cwyu
 * @since 2020-05-13
 */
@Data
public class PartyBranchAuditRes implements Serializable {

    private static final long serialVersionUID=1L;
    private Long id;

    /**
     * 学号
     */
    private Long stuInfoId;

    /**
     * 个人组织部信息id
     * */
    private Long partyBranchId;

    /**
     * 审核状态,0待审核，1，审核通过，-1审核不通过
     */
    private Byte status;

    /**
     * 审核结果
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


}
