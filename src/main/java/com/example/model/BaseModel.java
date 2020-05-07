package com.example.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class BaseModel implements Serializable {
    private String statusName;
    private String auditStatusName;
    private String activeName;
}
