package com.example.model;

import java.io.Serializable;
import java.util.Date;

/**
 * stu_info
 * @author 
 */
public class StuInfo implements Serializable {
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getStuId() {
        return stuId;
    }

    public void setStuId(Long stuId) {
        this.stuId = stuId;
    }

    public Byte getSex() {
        return sex;
    }

    public void setSex(Byte sex) {
        this.sex = sex;
    }

    public Long getIdentityId() {
        return identityId;
    }

    public void setIdentityId(Long identityId) {
        this.identityId = identityId;
    }

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    public Long getProfessionId() {
        return professionId;
    }

    public void setProfessionId(Long professionId) {
        this.professionId = professionId;
    }

    public Byte getEduSys() {
        return eduSys;
    }

    public void setEduSys(Byte eduSys) {
        this.eduSys = eduSys;
    }

    public Date getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(Date admissionDate) {
        this.admissionDate = admissionDate;
    }

    public Date getGraduationDate() {
        return graduationDate;
    }

    public void setGraduationDate(Date graduationDate) {
        this.graduationDate = graduationDate;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Byte getEduLevel() {
        return eduLevel;
    }

    public void setEduLevel(Byte eduLevel) {
        this.eduLevel = eduLevel;
    }

    public Long getClassId() {
        return classId;
    }

    public void setClassId(Long classId) {
        this.classId = classId;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Byte getActive() {
        return active;
    }

    public void setActive(Byte active) {
        this.active = active;
    }
}