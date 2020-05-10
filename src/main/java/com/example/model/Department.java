package com.example.model;

import java.io.Serializable;

/**
 * department
 * @author 
 */
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}