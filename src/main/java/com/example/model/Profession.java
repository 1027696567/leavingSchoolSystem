package com.example.model;

import java.io.Serializable;

/**
 * profession
 * @author 
 */
public class Profession implements Serializable {
    private Long id;

    /**
     * 专业编号
     */
    private Long professionId;

    /**
     * 专业名称
     */
    private String name;

    /**
     * 所属院系
     */
    private Long deptId;

    /**
     * 所属类别
     */
    private String category;

    /**
     * 是否可用
     */
    private Byte active;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProfessionId() {
        return professionId;
    }

    public void setProfessionId(Long professionId) {
        this.professionId = professionId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Byte getActive() {
        return active;
    }

    public void setActive(Byte active) {
        this.active = active;
    }
}