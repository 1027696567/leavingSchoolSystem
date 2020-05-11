package com.example.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * audit_res
 * @author 
 */
@Data
public class AuditRes implements Serializable {
    private Long id;

    /**
     * 资讯id
     */
    private Long informationId;

    /**
     * 审核内容
     */
    private String content;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 创建人
     */
    private String createUser;

    /**
     * 更新人
     */
    private String updateUser;

    /**
     * 是否可用
     */
    private Byte active;

    private static final long serialVersionUID = 1L;

}