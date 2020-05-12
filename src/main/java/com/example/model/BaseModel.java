package com.example.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class BaseModel implements Serializable {
    /**
     * 上下架状态
     * */
    private String statusName;
    /**
     * 审核状态
     * */
    private String auditStatusName;
    /**
     * 是否可用
     * */
    private String activeName;

    /**
     * 注销状态
     * */
    private String cancelStatus;
}
