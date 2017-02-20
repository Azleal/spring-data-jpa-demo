package com.keveon.model.condition;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Column;
import java.io.Serializable;

/**
 * Created by Keveon on 2017/2/14.
 * 员工信息
 */
@Data
@RequiredArgsConstructor
public class EmployeeCondition implements Serializable {
    private static final long serialVersionUID = -1426297524794331156L;

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
    Integer gender;

    /**
     * 工作状态
     * true => 空闲
     * false => 忙碌
     */
    @Column(name = "emp_status")
    Boolean status;

    /**
     * 部门名称
     */
    String deptName;

    /**
     * 职位名称
     */
    String levelName;
}
