package com.keveon.model.condition;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Keveon on 2017/2/14.
 * 员工信息
 */
@Data
@RequiredArgsConstructor
public class EmployeeCondition implements Serializable {
    private static final long serialVersionUID = -1426297524794331156L;
    /**
     * 员工ID
     */
    Long id;

    /**
     * 员工姓名
     */
    String name;

    /**
     * 员工手机号
     */
    @Column(name = "emp_phone", length = 11)
    String phone;

    /**
     * 身份证号码
     */
    @Column(name = "emp_identity", length = 18)
    String identity;

    /**
     * 员工性别
     */
    @Column(name = "emp_gender")
    Boolean gender;

    /**
     * 员工出生日期
     */
    @Column(name = "emp_birthday")
    @Temporal(TemporalType.DATE)
    Date birthday;

    /**
     * 工作状态
     * true => 空闲
     * false => 忙碌
     */
    @Column(name = "emp_status")
    Boolean status;

    /**
     * 入职日期
     */
    @Column(name = "emp_entryDate")
    @Temporal(TemporalType.DATE)
    Date entryDate;

    /**
     * 离职日期
     */
    @Column(name = "emp_turnoverDate")
    @Temporal(TemporalType.DATE)
    Date turnoverDate;

    /**
     * 所在部门
     */
    Integer deptId;

    /**
     * 职位
     */
    Integer levelId;
}
