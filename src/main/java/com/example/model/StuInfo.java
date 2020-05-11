package com.example.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * stu_info
 * @author 
 */
@Data
public class StuInfo extends BaseModel implements Serializable {
    private Long id;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 学生姓名
     */
    private String name;

    /**
     * 学号
     */
    private Long stuId;

    /**
     * 性别
     */
    private Byte sex;

    /**
     * 身份证号码
     */
    private Long identityId;

    /**
     * 院系id
     */
    private Long deptId;

    /**
     * 专业id
     */
    private Long professionId;

    /**
     * 学制
     */
    private Byte eduSys;

    /**
     * 入学日期
     */
    private Date admissionDate;

    /**
     * 毕业日期
     */
    private Date graduationDate;

    /**
     * 出生日期
     */
    private Date birthday;

    /**
     * 教学层次（0：本科，1：硕士，2：博士）
     */
    private Byte eduLevel;

    /**
     * 班号
     */
    private Long classId;

    /**
     * 照片
     */
    private String img;

    /**
     * 是否可用
     */
    private Byte active;

    private static final long serialVersionUID = 1L;

}