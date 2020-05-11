package com.example.model;

import lombok.Data;

import java.io.Serializable;

/**
 * profession
 * @author 
 */
@Data
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

}