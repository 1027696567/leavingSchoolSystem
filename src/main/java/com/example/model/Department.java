package com.example.model;

import lombok.Data;

import java.io.Serializable;

/**
 * department
 * @author 
 */
@Data
public class Department implements Serializable {
    private Long id;

    /**
     * 部门编号
     */
    private Long deptId;

    /**
     * 部门名称
     */
    private String name;

    private static final long serialVersionUID = 1L;

}